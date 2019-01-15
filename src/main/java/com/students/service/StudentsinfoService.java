package com.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.bean.Studentsinfo;
import com.students.bean.StudentsinfoExample;
import com.students.bean.StudentsinfoExample.Criteria;
import com.students.bean.Studentspass;
import com.students.bean.StudentspassExample;
import com.students.mapper.StudentsinfoMapper;
import com.students.mapper.StudentspassMapper;

@Service
public class StudentsinfoService {
	
	@Autowired
	private StudentsinfoMapper studentsinfoMapper;
	
	@Autowired
	 private StudentspassMapper studentspassMapper;
	

	public void deleteStuInfo(String id) {
		// TODO Auto-generated method stub
		studentsinfoMapper.deleteByPrimaryKey(id);
		
	}

	public List<Studentsinfo> getOne(String stuId) {
		// TODO Auto-generated method stub
		StudentsinfoExample example=new StudentsinfoExample();
		Criteria cri=example.createCriteria();
		cri.andStuIdLike(stuId);
		
		return studentsinfoMapper.selectByExample(example);
		
	}

	public List<Studentsinfo> getAll() {
		// TODO Auto-generated method stub
		return studentsinfoMapper.selectByExample(null);
		
	}

	public void updateStudentsinfo(Studentsinfo studentsinfo) {
		// TODO Auto-generated method stub
		studentsinfoMapper.updateByPrimaryKeySelective(studentsinfo);
		//studentsinfoMapper.updateByPrimaryKey(studentsinfo);
		
	}
   /**
    * shen新增学生，写入学生密码库 默认密码为学号
    * @param stuId
    */
	public boolean addStudentsinfo(String stuId) {
		// TODO Auto-generated method stub
		//先查询该学生是否被创建
		StudentspassExample example=new StudentspassExample();
		com.students.bean.StudentspassExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		int i=studentspassMapper.countByExample(example);
		if(i==0){
		
		
		Studentspass record=new Studentspass();
		record.setStuId(stuId);
		record.setStuPsw(stuId);
		studentspassMapper.insert(record);
		return true;
		}
		return false;
	}
	
	/**
	 * 查询学生用户是否被注册
	 * @param stuId
	 * @param password 
	 * @return
	 */
	
	public boolean isStudent(String stuId, String password){
		Studentspass studentPass=studentspassMapper.selectByPrimaryKey(stuId);
		if(studentPass!=null){
		if(studentPass.getStuPsw().equals(password)){
			return true;
		}
		}
		return false;
	}

	public boolean insert(Studentsinfo studentsinfo) {
		// TODO Auto-generated method stub
		int i=studentsinfoMapper.insertSelective(studentsinfo);
		if(i==0){
		return false;
		}
		return true;
	}

}
