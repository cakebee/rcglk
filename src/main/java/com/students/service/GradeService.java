package com.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.bean.Grade;
import com.students.mapper.GradeMapper;

@Service
public class GradeService {
	
	@Autowired
	private GradeMapper gradeMapper;
	
	public int save(Grade grade){
		return gradeMapper.insert(grade);
	}
	

}
