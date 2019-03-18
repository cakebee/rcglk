package com.students.service;

import com.students.bean.PaperExample;
import com.students.bean.StudentsorgExample;
import com.students.bean.StudentsprizeExample;
import com.students.mapper.PaperMapper;
import com.students.mapper.StudentsorgMapper;
import com.students.mapper.StudentsprizeMapper;
import com.students.utils.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BadgeService {
    @Autowired
    StudentsprizeMapper studentsprizeMapper;

    @Autowired
    StudentsorgMapper studentsorgMapper;

    @Autowired
    PaperMapper paperMapper;

    public HashMap<String, Integer> getAllBadge(){
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        int prizeBadge = getStudentsPrizeBadge();
        int orgBadge = getStudentsOrgBadge();
        int paperBadge = getPaperBadge();
        int allBadge = prizeBadge + orgBadge + paperBadge;

        resultMap.put("prizeBadge", prizeBadge);
        resultMap.put("orgBadge", orgBadge);
        resultMap.put("paperBadge", paperBadge);
        resultMap.put("allBadge", allBadge);

        return resultMap;
    }

    public int getStudentsPrizeBadge(){
        StudentsprizeExample example = new StudentsprizeExample();
        StudentsprizeExample.Criteria criteria =  example.createCriteria();
        criteria.andStatusEqualTo(Data.unReviewed.toString());
        return studentsprizeMapper.countByExample(example);
    }

    public int getStudentsOrgBadge(){
        StudentsorgExample example = new StudentsorgExample();
        StudentsorgExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Data.unReviewed);
        return studentsorgMapper.countByExample(example);
    }

    public int getPaperBadge(){
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Data.unReviewed);
        return paperMapper.countByExample(example);
    }
}
