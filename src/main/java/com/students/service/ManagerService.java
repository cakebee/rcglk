package com.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.bean.Manager;
import com.students.mapper.ManagerMapper;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerMapper managerMapper;
	
	public boolean isManager(String managerId, String password){
	  Manager manager=managerMapper.selectByPrimaryKey(managerId);
	  if(manager==null) {
		  return false;
	  }
	  if(manager.getManagerPass().equals(password)){
			
			return true;
		}
	  
		return false;
		
	}
	
	public void addManager(String managerId){
		Manager record=new Manager();
		record.setManagerId(managerId);
		record.setManagerPass(managerId);
		managerMapper.insertSelective(record);
	}

	public void updateManager(Manager manager) {
		// TODO Auto-generated method stub
		managerMapper.updateByPrimaryKey(manager);
		
	}

	public void deleteManager(String id) {
		// TODO Auto-generated method stub
		managerMapper.deleteByPrimaryKey(id);
		
	}

	public List<Manager> getAll() {
		// TODO Auto-generated method stub
		return managerMapper.selectByExample(null);
	}

	public Manager getOne(String managerId) {
		// TODO Auto-generated method stub
		return managerMapper.selectByPrimaryKey(managerId);
	}

}
