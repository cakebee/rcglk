package com.students.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import com.students.mapper.ResumeMapper;
import com.students.utils.SerializeUtils;

@Service
public class SerializeService {

  @Autowired
  private ResumeMapper resumeMapper;

public boolean addResume(String resume, String stuId) throws IOException {
	// TODO Auto-generated method stub
	String path="/data/wwwroot/default/rcglk/resume/resume"+stuId+".txt";
	File file=new File(path);
	if(file.exists()) {
		file.delete();
	}
	return SerializeUtils.serialize(resume, path);
	
	
}

public boolean deleteResume(String stuId) {
	// TODO Auto-generated method stub
	String path="/data/wwwroot/default/rcglk/resume/resume"+stuId+".txt";
	File file=new File(path);
	boolean bool=false;
	if(file.exists()) {
		bool=file.delete();
	}
	return bool;
}

public String getResume(String stuId) throws ClassNotFoundException, IOException {
	// TODO Auto-generated method stub
	String path="/data/wwwroot/default/rcglk/resume/resume"+stuId+".txt";
	File file=new File(path);
	
	if(file.exists()) {
		Object obj=SerializeUtils.serializeToObject(path);
		return (String)obj;
	}
	return null;
}
}
