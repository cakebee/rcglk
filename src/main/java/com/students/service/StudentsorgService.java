package com.students.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.bean.Studentsorg;
import com.students.bean.StudentsorgExample;
import com.students.bean.StudentsorgExample.Criteria;
import com.students.mapper.StudentsorgMapper;

@Service
public class StudentsorgService {
	
	@Autowired
	private StudentsorgMapper studentsorgMapper;

	public boolean addOrg(Studentsorg studentsorg) {
		// TODO Auto-generated method stub
		 int i=studentsorgMapper.insert(studentsorg);
		if(i>0){
			return true;
		}
		return false;
		
	}

	public boolean deleteOrg(String stuId) {
		// TODO Auto-generated method stub
		
		StudentsorgExample example=new StudentsorgExample();
		Criteria cri=example.createCriteria();
		cri.andStuIdEqualTo(stuId);
		
		int i=studentsorgMapper.deleteByExample(example);
		if(i>0){
			return true;
		}
		return false;
		
	}

	public List<Studentsorg> getOrg(String stuId) {
		// TODO Auto-generated method stub
		StudentsorgExample example=new StudentsorgExample();
		Criteria cri=example.createCriteria();
		cri.andStuIdEqualTo(stuId);
		
		
		List<Studentsorg> org=studentsorgMapper.selectByExample(example);
//		for(Studentsorg o:org) {
//			System.out.println(o);
//		}
		return org;
	}

	public boolean saveOrg(Studentsorg studentsorg) {
		// TODO Auto-generated method stub
		
		
		
		int i=studentsorgMapper.updateByPrimaryKey(studentsorg);
		if(i>0){
			return true;
		}
		return false;
		
	}

	public List<Studentsorg> getAll() {
		// TODO Auto-generated method stub
		StudentsorgExample example=new StudentsorgExample();
		Criteria cri=example.createCriteria();
		
		
		
		return studentsorgMapper.selectByExample(example);
		
	}

	public Studentsorg getOne(int orgId) {
		// TODO Auto-generated method stub
		return studentsorgMapper.selectByPrimaryKey(orgId);
	}

}
