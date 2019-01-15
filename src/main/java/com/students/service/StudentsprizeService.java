package com.students.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.students.bean.Studentsprize;
import com.students.bean.StudentsprizeExample;
import com.students.bean.StudentsprizeExample.Criteria;
import com.students.mapper.StudentsprizeMapper;

@Service
public class StudentsprizeService {
	
	@Autowired
	private StudentsprizeMapper studentsprizeMapper;
	
	/**
	 * tonggu通过学号和审核状态得到prize信息
	 * @param stuId
	 * @param status
	 * @return
	 */

	public List<Studentsprize> getPrize(String stuId, String status) {
		// TODO Auto-generated method stub
		StudentsprizeExample example=new StudentsprizeExample();
		Criteria cri=  example.createCriteria();
	    cri.andStatusEqualTo(status);
	    
	    
	    if(!stuId.equals("0")){
	    	System.out.println("1");
	    cri.andStuIdEqualTo(stuId);
	    }
	    
		return studentsprizeMapper.selectByExample(example);
	}

	public boolean deleteprize(int prizeId) {
		// TODO Auto-generated method stub
		int i=studentsprizeMapper.deleteByPrimaryKey(prizeId);
		if(i==0){
			
			
			return false;
			}
			return true;
			

	}

	public boolean savaPrize(Studentsprize studentsprize) {
		// TODO Auto-generated method stub
		
		studentsprize.setStatus("0");
		
		int i=studentsprizeMapper.updateByPrimaryKeySelective(studentsprize);
		System.out.println(studentsprize);
        System.out.println(i);
		if(i==0){
			
		
		return false;
		}
		return true;
		
	}

	public Integer addPrize(Studentsprize studentsPrize) {
		// TODO Auto-generated method stub
		Calendar ca=Calendar.getInstance();
		Date date=ca.getTime();
		studentsPrize.setStatus("0");
		studentsPrize.setSubmitDate(date);
		studentsprizeMapper.insertSelective(studentsPrize);
		StudentsprizeExample example=new StudentsprizeExample();
		Criteria cri= example.createCriteria();
		cri.andStuIdEqualTo(studentsPrize.getStuId());
		cri.andPrizeNameEqualTo(studentsPrize.getPrizeName());
		//cri.andPrizeFileEqualTo(null);
		
		
	    List<Studentsprize> list=	studentsprizeMapper.selectByExample(example);
	    int prizeId=0;
	    for(Studentsprize prize:list) {
	    	 prizeId=prize.getPrizeId();
	    }
		return prizeId;
		
	}
	
	public void setFile(String fileph,int prizeId) {
		Studentsprize prize=studentsprizeMapper.selectByPrimaryKey(prizeId);
	    prize.setPrizeFile(fileph);
	    studentsprizeMapper.updateByPrimaryKey(prize);
		
	}

	public void check(String isPassed, Integer prizeId,String reason) {
		// TODO Auto-generated method stub
		Calendar ca=Calendar.getInstance();
		Date date=ca.getTime();
		
		Studentsprize studentsprize=new Studentsprize();
		studentsprize.setPrizeId(prizeId);
		studentsprize.setCheckTime(date);
		studentsprize.setReason(reason);
		
		if(isPassed.equals("pass")){
			
			studentsprize.setStatus("1");
			
			studentsprizeMapper.updateByPrimaryKeySelective(studentsprize);
		}else{
			studentsprize.setStatus("2");
			studentsprizeMapper.updateByPrimaryKeySelective(studentsprize);
		}
		
	}

	public Studentsprize getOne(int prizeId) {
		// TODO Auto-generated method stub
		return studentsprizeMapper.selectByPrimaryKey(prizeId);
	}

	public PageInfo<Studentsprize> getByDate(int pageNum, int pageSize, Date submitDate1, Date submitDate2) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageInfo<Studentsprize> getBySumbit(int pageNum, int pageSize, Date submitDate1, Date submitDate2) {
		// TODO Auto-generated method stub
		return null;
	}

}
