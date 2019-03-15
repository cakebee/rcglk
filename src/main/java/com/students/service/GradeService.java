package com.students.service;

import com.students.bean.GradeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.bean.Grade;
import com.students.mapper.GradeMapper;

import java.util.List;

@Service
public class GradeService {
	
	@Autowired
	private GradeMapper gradeMapper;
	
	public int save(Grade grade){
		return gradeMapper.insert(grade);
	}
	
	public List<Grade> getAll(){
		return gradeMapper.selectByExample(null);
	}

    public List<Grade> getGrade(String stuId) {
		GradeExample example = new GradeExample();
		GradeExample.Criteria criteria = example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return gradeMapper.selectByExample(example);
    }
}
