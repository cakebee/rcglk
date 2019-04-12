package com.students.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.SearchOrg;
import com.students.bean.Studentsorg;
import com.students.bean.StudentsorgExample;
import com.students.mapper.StudentsorgMapper;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import com.students.utils.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentsorgService {

    @Autowired
    private StudentsorgMapper studentsorgMapper;

    /**
     * @Description: 添加一个组织活动的记录，并保存证明文件，两个参数都不能为null，否则返回false
     * @Param: studentsorg
     * @Param: file
     * @Return: boolean
     * @author: zxy
     * @create: 2019/4/9 10:43
     **/
    public boolean addOrg(Studentsorg studentsorg, MultipartFile file) throws IOException {
        // TODO Auto-generated method stub
        File savedFile;
        /*存储证明文件*/
        if(file != null){
            if((savedFile = saveFile(file)) != null){
                /*向数据库中插入记录*/
                Calendar ca = Calendar.getInstance();
                Date date = ca.getTime();
                studentsorg.setSubmitDate(date);
                studentsorg.setStatus(Data.unReviewed);
                studentsorg.setFile(savedFile.getName());
                int i = studentsorgMapper.insert(studentsorg);
                if (i > 0) {
                    return true;
                }
                else {
                    savedFile.delete();
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @Description:
     * @Param: studentsorg
     * @Param: newFile
     * @Return: boolean
     * @author: zxy
     * @create: 2019/4/9 22:32
     **/
    public boolean updateOrg(Studentsorg studentsorg, MultipartFile newFile) throws IOException{
        Calendar ca = Calendar.getInstance();
        Date date = ca.getTime();
        File savedFile = null;
        File oldFile = null;
        Studentsorg oldOrg = null;

        studentsorg.setSubmitDate(date);
        studentsorg.setStatus(Data.unReviewed);

        /*更换新的证明文件*/
        if(newFile != null){
            /*存储新的证明文件*/
            if((savedFile = saveFile(newFile)) != null){
                /*传递的studentorg中的orgid有效*/
                if(Data.isValid(studentsorg.getOrgId())){
                    oldOrg = studentsorgMapper.selectByPrimaryKey(studentsorg.getOrgId());
                    /*存在该id的记录*/
                    if (oldOrg != null){
                        oldFile = new File(Path.org + oldOrg.getFile());
                        studentsorg.setFile(savedFile.getName());
                        if(studentsorgMapper.updateByPrimaryKeySelective(studentsorg) == 1){
                            /*记录插入成功，删除旧的证明文件*/
                            oldFile.delete();
                            return true;
                        }
                        else {
                            /*记录插入失败，删除新的证明文件*/
                            savedFile.delete();
                        }
                    }
                }
            }
            return false;
        }

        if(studentsorgMapper.updateByPrimaryKeySelective(studentsorg) == 1){
            return true;
        }
        return false;
    }

    public File saveFile(MultipartFile file) throws IOException{
        String originalName = file.getOriginalFilename();
        String after = originalName.substring(originalName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replace("-","") + after;
        String savePath = Path.org + fileName;
        File saveFile = new File(savePath);

        /*设置可读权限*/
        Runtime.getRuntime().exec("chmod 777 -R " + savePath);
        /*if(!saveFile.setReadable(true)){
            return null;
        }*/
        file.transferTo(saveFile);
        return saveFile;
    }

    public boolean deleteOrg(String stuId) {
        // TODO Auto-generated method stub

        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria cri = example.createCriteria();
        cri.andStuIdEqualTo(stuId);

        int i = studentsorgMapper.deleteByExample(example);
        if (i > 0) {
            return true;
        }
        return false;

    }

    public boolean deleteOrg(Integer orgId) {
        Studentsorg studentsorg = studentsorgMapper.selectByPrimaryKey(orgId);
        String filePath = Path.org + studentsorg.getFile();
        File file = new File(filePath);

        if (!file.delete()) {
            return false;
        }

        if (studentsorgMapper.deleteByPrimaryKey(orgId) == 1) {
            return true;
        } else return false;
    }

    public List<Studentsorg> getOrg(String stuId) {
        // TODO Auto-generated method stub
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria cri = example.createCriteria();
        cri.andStuIdEqualTo(stuId);


        List<Studentsorg> org = studentsorgMapper.selectByExample(example);
//		for(Studentsorg o:org) {
//			System.out.println(o);
//		}
        return org;
    }

    public boolean saveOrg(Studentsorg studentsorg) {
        // TODO Auto-generated method stub


        int i = studentsorgMapper.updateByPrimaryKey(studentsorg);
        if (i > 0) {
            return true;
        }
        return false;

    }

    public List<Studentsorg> getAll() {
        // TODO Auto-generated method stub
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria cri = example.createCriteria();
        return studentsorgMapper.selectByExample(example);

    }

    public List<Studentsorg> getAll(Integer status) {
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return studentsorgMapper.selectByExample(example);
    }

    public PageBean<Studentsorg> getAllByPage() {
        return selectByPage(null);
    }

    public PageBean<Studentsorg> getAllByPage(String studentId, Integer status) {
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(studentId);
        criteria.andStatusEqualTo(status);
        return selectByPage(example);
    }

    public PageBean<Studentsorg> searchByPage(SearchOrg searchOrg) {
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria criteria = example.createCriteria();

        if (Data.isValid(searchOrg.getStuName())) {
            criteria.andStuNameLike("%" + searchOrg.getStuName() + "%");
        }
        if (Data.isValid(searchOrg.getStuId())) {
            criteria.andStuIdLike("%" + searchOrg.getStuId() + "%");
        }
        if (Data.isValid(searchOrg.getOrgClass())) {
            criteria.andOrgClassLike("%" + searchOrg.getOrgClass() + "%");
        }
        if (Data.isValid(searchOrg.getOrgDuty())) {
            criteria.andOrgDutyLike("%" + searchOrg.getOrgDuty() + "%");
        }
        if (Data.isValid(searchOrg.getOrgName())) {
            criteria.andOrgNameLike("%" + searchOrg.getOrgName() + "%");
        }
        if (Data.isValid(searchOrg.getOrgBegin())) {
            criteria.andOrgBeginGreaterThanOrEqualTo(searchOrg.getOrgBegin());
        }
        if (Data.isValid(searchOrg.getOrgEnd())) {
            criteria.andOrgEndLessThanOrEqualTo(searchOrg.getOrgEnd());
        }
        if (Data.isValid(searchOrg.getSubmitDateBegin())) {
            criteria.andSubmitDateGreaterThanOrEqualTo(searchOrg.getSubmitDateBegin());
        }
        if (Data.isValid(searchOrg.getSubmitDateEnd())) {
            criteria.andSubmitDateLessThanOrEqualTo(searchOrg.getSubmitDateEnd());
        }
        if (Data.isValid(searchOrg.getReviewDateBegin())) {
            criteria.andReviewDateGreaterThanOrEqualTo(searchOrg.getReviewDateBegin());
        }
        if (Data.isValid(searchOrg.getReviewDateEnd())) {
            criteria.andReviewDateLessThanOrEqualTo(searchOrg.getReviewDateEnd());
        }
        return selectByPage(example);
    }

    private PageBean<Studentsorg> selectByPage(StudentsorgExample example) {
        Page<Studentsorg> page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        List<Studentsorg> studentsorgList = studentsorgMapper.selectByExample(example);
        PageBean<Studentsorg> studentsorgPageBean = new PageBean<Studentsorg>(studentsorgList);
        studentsorgPageBean.setTotal(page.getTotal());
        studentsorgPageBean.setPageSize(page.getPageSize());
        studentsorgPageBean.setCurrPage(page.getPageNum());
        studentsorgPageBean.setPages(page.getPages());
        return studentsorgPageBean;
    }

    public Studentsorg getOne(int orgId) {
        // TODO Auto-generated method stub
        return studentsorgMapper.selectByPrimaryKey(orgId);
    }

    public void review(String isPassed, Integer orgId, String reason) {
        Calendar ca = Calendar.getInstance();
        Date date = ca.getTime();

        Studentsorg studentsorg = new Studentsorg();
        studentsorg.setReviewDate(date);
        studentsorg.setOrgId(orgId);

        if (isPassed.equals("pass")) {
            studentsorg.setStatus(Data.reviewPass);
        } else {
            studentsorg.setStatus(Data.reviewNotPass);
            studentsorg.setReason(reason);
        }
        studentsorgMapper.updateByPrimaryKeySelective(studentsorg);
    }
}
