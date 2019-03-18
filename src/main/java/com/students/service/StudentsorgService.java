package com.students.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.Msg;
import com.students.bean.SearchOrg;
import com.students.bean.Studentsorg;
import com.students.bean.StudentsorgExample;
import com.students.mapper.StudentsorgMapper;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import com.sun.webkit.graphics.WCPageBackBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsorgService {

    @Autowired
    private StudentsorgMapper studentsorgMapper;

    public boolean addOrg(Studentsorg studentsorg) {
        // TODO Auto-generated method stub
        Calendar ca = Calendar.getInstance();
        Date date = ca.getTime();
        studentsorg.setSubmitDate(date);
        studentsorg.setStatus(Data.unReviewed);
        int i = studentsorgMapper.insert(studentsorg);
        if (i > 0) {
            return true;
        }
        return false;

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

    public List<Studentsorg> getAll(Integer status){
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return studentsorgMapper.selectByExample(example);
    }

    public PageBean<Studentsorg> getAllByPage() {
        return selectByPage(null);
    }

    public PageBean<Studentsorg> searchByPage(SearchOrg searchOrg){
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria criteria = example.createCriteria();

        if(Data.isValid(searchOrg.getStuName())){
            criteria.andStuNameLike("%" + searchOrg.getStuName() + "%");
        }
        if(Data.isValid(searchOrg.getStuId())){
            criteria.andStuIdLike("%" + searchOrg.getStuId() + "%");
        }
        if(Data.isValid(searchOrg.getOrgClass())){
            criteria.andOrgClassLike("%" + searchOrg.getOrgClass() + "%");
        }
        if (Data.isValid(searchOrg.getOrgDuty())) {
            criteria.andOrgDutyLike("%" + searchOrg.getOrgDuty() + "%");
        }
        if(Data.isValid(searchOrg.getOrgName())){
            criteria.andOrgNameLike("%" + searchOrg.getOrgName() + "%");
        }
        if(Data.isValid(searchOrg.getOrgBegin())){
            criteria.andOrgBeginGreaterThanOrEqualTo(searchOrg.getOrgBegin());
        }
        if(Data.isValid(searchOrg.getOrgEnd())){
            criteria.andOrgEndLessThanOrEqualTo(searchOrg.getOrgEnd());
        }
        if(Data.isValid(searchOrg.getSubmitDateBegin())){
            criteria.andSubmitDateGreaterThanOrEqualTo(searchOrg.getSubmitDateBegin());
        }
        if(Data.isValid(searchOrg.getSubmitDateEnd())){
            criteria.andSubmitDateLessThanOrEqualTo(searchOrg.getSubmitDateEnd());
        }
        if(Data.isValid(searchOrg.getReviewDateBegin())){
            criteria.andReviewDateGreaterThanOrEqualTo(searchOrg.getReviewDateBegin());
        }
        if(Data.isValid(searchOrg.getReviewDateEnd())){
            criteria.andReviewDateLessThanOrEqualTo(searchOrg.getReviewDateEnd());
        }
        return selectByPage(example);
    }

    private PageBean<Studentsorg> selectByPage(StudentsorgExample example){
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

}
