package com.students.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.Paper;
import com.students.bean.PaperExample;
import com.students.bean.SearchPaper;
import com.students.mapper.PaperMapper;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import com.students.utils.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PaperService {

    @Autowired
    private PaperMapper paperMapper;

    public List<Paper> getAll(){
        PaperExample example = new PaperExample();
        return paperMapper.selectByExample(example);
    }

    public List<Paper> getAll(Integer status){
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return paperMapper.selectByExample(example);
    }

    public List<Paper> getSamePaper(String name){
        if(name == null){
            return null;
        }

        List<Paper> paperList;
        String front, end;
        if(name.length() == 1){
            front = name;
            end = name;
        }else {
            front = name.substring(0, name.length() / 2);
            end = name.substring(name.length() / 2);
        }

        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + front + "%");
        example.or().andNameLike("%" + end + "%");
        paperList = paperMapper.selectByExample(example);


        /*System.out.println("---搜索 front：" + front);
        System.out.println("---搜索 end：" + end);
        System.out.println(name.length() + " " + name.length() / 2);*/

        return paperList;
    }

    public PageBean<Paper> getAllByPage(String stuId, Integer status){
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        if(status != null && status != -1){
            criteria.andStatusEqualTo(status);
        }
        if(stuId != null && !stuId.equals("-1")){
            criteria.andStuIdEqualTo(stuId);
        }
        return startSelect(example);
    }

    public PageBean<Paper> fuzzySearch(SearchPaper paper){
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();

        if(Data.isValid(paper.getName())){
            criteria.andNameLike("%" + paper.getName() + "%");
        }
        if(Data.isValid(paper.getAuthor())){
            criteria.andAuthorLike("%" + paper.getAuthor() + "%");
        }
        if(Data.isValid(paper.getPeriodical())){
            criteria.andPeriodicalLike("%" + paper.getPeriodical() + "%");
        }
        if(Data.isValid(paper.getLevel())){
            criteria.andLevelEqualTo(paper.getLevel());
        }
        if(Data.isValid(paper.getAuthorLevel())){
            criteria.andAuthorLevelEqualTo(paper.getAuthorLevel());
        }
        if(Data.isValid(paper.getDateBegin())){
            criteria.andDateGreaterThanOrEqualTo(paper.getDateBegin());
        }
        if(Data.isValid(paper.getDateEnd())){
            criteria.andDateLessThanOrEqualTo(paper.getDateEnd());
        }
        if(Data.isValid(paper.getPaperId())){
            criteria.andPaperIdEqualTo(paper.getPaperId());
        }
        if(Data.isValid(paper.getSubmitDateBegin())){
            criteria.andSubmitDateGreaterThanOrEqualTo(paper.getSubmitDateBegin());
        }
        if(Data.isValid(paper.getSubmitDateEnd())){
            criteria.andSubmitDateLessThanOrEqualTo(paper.getSubmitDateEnd());
        }
        if(Data.isValid(paper.getReviewDateBegin())){
            criteria.andReviewDateGreaterThanOrEqualTo(paper.getSubmitDateBegin());
        }
        if(Data.isValid(paper.getReviewDateEnd())){
            criteria.andReviewDateLessThanOrEqualTo(paper.getSubmitDateEnd());
        }

        return startSelect(example);
    }

    private PageBean<Paper> startSelect(PaperExample example){
        Page<Paper> page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        PageBean<Paper> paperPageBean = new PageBean<Paper>(paperMapper.selectByExample(example));
        paperPageBean.setCurrPage(page.getPageNum());
        paperPageBean.setTotal(page.getTotal());
        paperPageBean.setPageSize(page.getPageSize());
        paperPageBean.setPages(page.getPages());
        return paperPageBean;
    }

    public Paper getPaper(Integer id){
        return paperMapper.selectByPrimaryKey(id);
    }

    public List<Paper> getPaper(String stuId) {
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        return paperMapper.selectByExample(example);
    }

    public void review(String isPassed, Integer paperId, String reason){
        Calendar ca = Calendar.getInstance();
        Date date = ca.getTime();
        Paper paper = new Paper();

        paper.setId(paperId);
        paper.setReviewDate(date);

        if(isPassed.equals("pass")){//通过
            paper.setStatus(Data.reviewPass);
        }else {
            paper.setReason(reason);
            paper.setStatus(Data.reviewNotPass);
        }
        paperMapper.updateByPrimaryKeySelective(paper);
    }


    /*如果存在该id的paper，则更新paper，如果文件不为空，同时更新文件，删除旧文件
    如果不存在该id的paper，且文件不为空，则插入该paper；若为空则不操作*/
    public int addOrUpdatePaper(Paper paper, MultipartFile file) throws IOException {
        Calendar ca = Calendar.getInstance();
        Date date = ca.getTime();

        paper.setSubmitDate(date);
        paper.setStatus(Data.unReviewed);

        if(file != null){
            String originalName = file.getOriginalFilename();
            String after = originalName.substring(originalName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString().replace("-","") + after;
            String savePath = Path.paper + fileName;
            File newFile = new File(savePath);
            file.transferTo(newFile);
            /*设置可读权限*/
            Runtime.getRuntime().exec("chmod 777 -R " + savePath);
            /*if(!newFile.setReadable(true)){
                return 0;
            }*/

            paper.setFile(fileName);
        }

        Paper oldPaper = paperMapper.selectByPrimaryKey(paper.getId());

        //更新paper
        if(oldPaper != null){
            File oldFile = new File(Path.paper + oldPaper.getFile());
            //判断是否仅更新记录不更新文件
            if(file == null){
                paper.setFile(oldPaper.getFile());
            }else {
                oldFile.delete();
            }
            return paperMapper.updateByPrimaryKeySelective(paper);
        }
        //插入paper
        else {
            if(file == null){
                return 0;
            }
            int result = paperMapper.insertSelective(paper);

            if(paper.getPaperId() == null){
                paper.setPaperId(0);
            }
            if(paper.getPaperId() > 0){
                return result;
            }else {
                PaperExample example = new PaperExample();
                PaperExample.Criteria criteria = example.createCriteria();
                criteria.andPaperIdEqualTo(0);
                List<Paper> list = paperMapper.selectByExample(example);
                for(Paper p : list){
                    p.setPaperId(p.getId());
                    paperMapper.updateByPrimaryKeySelective(p);
                }
            }
            return result;
        }
    }

    public boolean deletePaper(Integer id) {
        Paper paper = paperMapper.selectByPrimaryKey(id);
        String filePath = Path.paper + paper.getFile();
        File file = new File(filePath);
        if(file.delete()){
            if(paperMapper.deleteByPrimaryKey(id) == 1){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }

    public int updatePaper(Paper paper){
        Calendar ca = Calendar.getInstance();
        Date date = ca.getTime();

        paper.setSubmitDate(date);
        paper.setStatus(Data.unReviewed);

        return paperMapper.updateByPrimaryKey(paper);
    }
}
