package com.students.service;

import com.students.bean.StudentsprizeExample;
import com.students.mapper.StudentsprizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BadgeService {
    @Autowired
    StudentsprizeMapper studentsprizeMapper;

    public HashMap<String, Integer> getAllBadge(){
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("prizeBadge", getStudentsPrizeBadge());
        return resultMap;
    }

    public int getStudentsPrizeBadge(){
        StudentsprizeExample example = new StudentsprizeExample();
        StudentsprizeExample.Criteria criteria =  example.createCriteria();
        criteria.andStatusEqualTo("0");
        return studentsprizeMapper.countByExample(example);
    }
}
