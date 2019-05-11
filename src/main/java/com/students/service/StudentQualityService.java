package com.students.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.*;
import com.students.mapper.StudentsqualityMapper;
import com.students.utils.Data;
import com.students.utils.DecisionTree;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import com.students.utils.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentQualityService {

    @Autowired
    private StudentsqualityMapper studentsqualityMapper;

    @Autowired
    private DecisionTree decisionTree;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentsorgService studentsorgService;

    @Autowired
    private StudentsprizeService studentsprizeService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private StudentsinfoService studentsinfoService;

    private String fileDir = Path.DTreeTrainData;

    //评价等级对照，用于将数据库中读取的评价等级转换成文字描述
    private String [] cQuality = {"较差", "一般", "良好", "优秀", "无"};
    //评价默认值
    private int qualityDefualt = 0;
    //缺少数据，无评价值
    private int qualityEmpty = 4;

    //科研能力评价标准（分值）
    private int[] cSci = {0, 5, 10};
    //在校成绩评价标准（平均绩点）
    private float[] cGrade = {2.0f, 3.0f, 3.9f};
    //组织管理能力评价标准（任职天数）
    private int[] cOrg = {0, 180, 180*3};

    //科研能力属性名
    private String attrSci = "q_scientific";
    //在校成绩属性名
    private String attrGrade = "q_grade";
    //组织管理能力属性名
    private String attrOrg = "q_org";
    //学生综合素质属性名
    private String attrQua = "quality";


    //获奖分值标准，使用hashmap加快查询速度
    private HashMap<String, HashMap<String, Integer>> cPrize = new HashMap<String, HashMap<String, Integer>>(){
        {
            put("国际级", new HashMap<String, Integer>(){
                {
                    put("一等奖", 15);
                    put("二等奖", 10);
                    put("三等奖", 8);
                    put("其他", 4);
                }
            });
            put("国家级", new HashMap<String, Integer>(){
                {
                    put("一等奖", 10);
                    put("二等奖", 8);
                    put("三等奖", 6);
                    put("其他", 3);
                }
            });
            put("省级", new HashMap<String, Integer>(){
                {
                    put("一等奖", 8);
                    put("二等奖", 6);
                    put("三等奖", 5);
                    put("其他", 2);
                }
            });
            put("市级", new HashMap<String, Integer>(){
                {
                    put("一等奖", 6);
                    put("二等奖", 4);
                    put("三等奖", 3);
                    put("其他", 1);
                }
            });
            put("校级", new HashMap<String, Integer>(){
                {
                    put("一等奖", 4);
                    put("二等奖", 3);
                    put("三等奖", 1);
                    put("其他", 0);
                }
            });
        }
    };

    //论文分值标准
    private HashMap<String, Integer> cPaper = new HashMap<String, Integer>(){
        {
            put("SCI", 10);
            put("EI/CSSI/SSCI/一级刊物", 5);
            put("核心期刊", 5);
            put("公开发表", 2);
        }
    };

    //收集学生的信息
    public HashMap<String, HashMap<String,String>> collectData(){

        //（暂未使用）决策树需要处理的数据
        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();

        //临时存放data：[学号, [属性, 属性值]]
        HashMap<String,HashMap<String,String>> tmpData = new HashMap<String, HashMap<String, String>>();

        //收集学生的在校成绩
        List<Grade> grades = gradeService.getAll();
        for(Grade grade : grades){
            HashMap<String,String> map = new HashMap<String, String>();//存放单个学生的各个属性值
            String q = "0";
            float avgPoint = grade.getAvgPonit();
            int i=0;
            while((i<cGrade.length && avgPoint > cGrade[i])  ){
                i++;
            }
            map.put(attrGrade, Integer.toString(i));
            map.put(attrSci, Integer.toString(qualityDefualt));
            map.put(attrOrg, Integer.toString(qualityDefualt));
            tmpData.put(grade.getStuId(), map);
        }

        //收集学生的获奖、论文数据
        HashMap<String, Integer> points = new HashMap<String, Integer>();
        List<Studentsprize> studentsPrizes = studentsprizeService.getPrize("0","1");
        for(Studentsprize sp : studentsPrizes){
            if(points.containsKey(sp.getStuId())){
                int newPoint = points.get(sp.getStuId()) + cPrize.get(sp.getPrizeLevel()).get(sp.getPrizeLevel2());
                points.put(sp.getStuId(), newPoint);
            }else {
                points.put(sp.getStuId(), cPrize.get(sp.getPrizeLevel()).get(sp.getPrizeLevel2()));
            }
        }

        List<Paper> papers = paperService.getAll();
        for(Paper paper : papers){
            if(points.containsKey(paper.getStuId())){
                int newPoint = points.get(paper.getStuId()) + cPaper.get(paper.getLevel());
                points.put(paper.getStuId(), newPoint);
            }
        }

        for(Map.Entry<String,Integer> e : points.entrySet()){
            int i = 0;
            int point = e.getValue();
            while((i<cSci.length && point > cSci[i])){
                i++;
            }
            if(tmpData.containsKey(e.getKey())){
                tmpData.get(e.getKey()).put(attrSci, Integer.toString(i));
            }
            else {
                HashMap<String, String> m = new HashMap<String, String>();
                m.put(attrSci, Integer.toString(i));
                tmpData.put(e.getKey(), m);
            }
        }

        //收集学生的组织经历
        List<Studentsorg> studentsorgs = studentsorgService.getAll();
        HashMap<String, Long> termMap = new HashMap<String, Long>();
        for(Studentsorg studentsorg : studentsorgs){
            long term = 0; //任期，单位为天
            term = (studentsorg.getOrgEnd().getTime() - studentsorg.getOrgBegin().getTime()) / ( 1000 * 60 * 60 * 24 );
            if(termMap.containsKey(studentsorg.getStuId())){
                termMap.put(studentsorg.getStuId(), termMap.get(studentsorg.getStuId()) + term);
            }else {
                termMap.put(studentsorg.getStuId(), term);
            }
        }

        for(Map.Entry<String, Long> entry : termMap.entrySet()){
            int i = 0; //评级
            while( i<cOrg.length && (entry.getValue() > cOrg[i])){
                i++;
            }
            if(tmpData.containsKey(entry.getKey())){
                tmpData.get(entry.getKey()).put(attrOrg, Integer.toString(i));
            }
            else {
                HashMap<String, String> m = new HashMap<String, String>();
                m.put(attrOrg, Integer.toString(i));
                tmpData.put(entry.getKey(), m);
            }
        }

        System.out.println(tmpData);

        return tmpData;
    }

    //保存生成的学生综合素质评价数据，并对null值进行处理
    public void saveData(HashMap<String, HashMap<String, String>> data){

        List<Studentsquality> studentsqualityList = new ArrayList<Studentsquality>();
        for(Map.Entry<String, HashMap<String, String>> entry : data.entrySet()){
            Studentsquality studentsquality = new Studentsquality();
            String q;

            studentsquality.setStuId(entry.getKey());
            if((q = entry.getValue().get(attrQua)) != null)
                studentsquality.setQuality(Integer.parseInt(q));
            else
                studentsquality.setQuality(qualityEmpty);

            if((q = entry.getValue().get(attrGrade)) != null)
                studentsquality.setqGrade(Integer.parseInt(q));
            else
                studentsquality.setqGrade(qualityEmpty);

            if((q = entry.getValue().get(attrSci)) != null)
                studentsquality.setqScientific(Integer.parseInt(q));
            else
                studentsquality.setqScientific(qualityEmpty);

            if((q = entry.getValue().get(attrOrg)) != null)
                studentsquality.setqOrg(Integer.parseInt(q));
            else
                studentsquality.setqOrg(qualityEmpty);

            studentsqualityList.add(studentsquality);
        }
        //System.out.println(studentsqualityList.size());
        studentsqualityMapper.replaceInto(studentsqualityList);
    }
    public boolean createTree(){
        decisionTree.createDTree(getTrainData(), getTrainAttrList());
        return true;
    }

    public int analyseData(HashMap<String, HashMap<String,String>> data){
        return decisionTree.run(data);
    }

    public List<Studentsquality> getAll(){
        return studentsqualityMapper.selectByExample(null);
    }

    public PageBean<HashMap<String, String>> getAllByPage(){
        Page<Studentsquality> page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        List<Studentsquality> studentsqualityList = studentsqualityMapper.selectByExample(null);
        PageBean<HashMap<String, String>> studentsqualityPageBean = new PageBean<HashMap<String, String>>(transData(studentsqualityList));
        studentsqualityPageBean.setCurrPage(page.getPageNum());
        studentsqualityPageBean.setPages(page.getPages());
        studentsqualityPageBean.setTotal(page.getTotal());
        studentsqualityPageBean.setPageSize(page.getPageSize());
        return studentsqualityPageBean;
    }

    public List<HashMap<String, String>> transData(List<Studentsquality> studentsqualities){
        List<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
        for(Studentsquality s : studentsqualities){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("stuId", s.getStuId());
            map.put("stuName", studentsinfoService.getOne(s.getStuId()).get(0).getStuName());
            map.put(attrSci, cQuality[s.getqScientific()]);
            map.put(attrGrade, cQuality[s.getqGrade()]);
            map.put(attrOrg, cQuality[s.getqOrg()]);
            map.put(attrQua, cQuality[s.getQuality()]);
            resultList.add(map);
        }
        return resultList;
    }

    public HashMap<String, Object> getStudentDetails(String stuId){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("prizeList", studentsprizeService.getPrize(stuId, Data.reviewPass.toString()));
        map.put("orgList", studentsorgService.getOrg(stuId));
        map.put("paperList", paperService.getPaper(stuId));
        map.put("grade", gradeService.getGrade(stuId).get(0));
        return map;
    }

    private List<ArrayList<String>> getTrainData(){
        List<ArrayList<String>> ll = new ArrayList<ArrayList<String>>();
        File f = new File(fileDir);
        int count = 0;
        try {
            String templine = null;
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((templine = br.readLine()) != null){
                if(count!=0){
                    String[] lines = templine.split("    ");
                    ArrayList<String> l = new ArrayList<String>();
                    for(String line: lines){
                        l.add(line);
                    }
                    ll.add(l);
                }
                count ++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ll);
        return ll;
    }

    private List<String> getTrainAttrList(){
        List<String> ll = new ArrayList<String>();
        File f = new File(fileDir);
        try {
            String templine = null;
            BufferedReader br = new BufferedReader(new FileReader(f));
            if ((templine = br.readLine()) != null){
                String[] lines = templine.split("    ");
                for(String line: lines){
                    ll.add(line);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ll);
        return ll;
    }
}
