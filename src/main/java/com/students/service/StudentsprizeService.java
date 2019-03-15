package com.students.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.SearchPrize;
import com.students.mapper.StudentsprizeMapper;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.students.bean.Studentsprize;
import com.students.bean.StudentsprizeExample;
import com.students.bean.StudentsprizeExample.Criteria;

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

	/*0 -1 查询所有学生所有状态*/
	public PageBean<Studentsprize> getPrizeByPage(String stuId, String status){
		StudentsprizeExample example=new StudentsprizeExample();
		Criteria cri=  example.createCriteria();
		if(!status.equals("-1")){
			cri.andStatusEqualTo(status);
		}
		if(!stuId.equals("0")){
			cri.andStuIdEqualTo(stuId);
		}
		return startSelect(example);
	}

	public PageBean<Studentsprize> searchPrizeByPage(SearchPrize searchPrize){
		StudentsprizeExample example = new StudentsprizeExample();
		Criteria criteria = example.createCriteria();

		if(Data.isValid(searchPrize.getPrizeName())){
			criteria.andPrizeNameLike("%" + searchPrize.getPrizeName() + "%");
		}
		if(Data.isValid(searchPrize.getStuId())){
			criteria.andStuIdLike("%" + searchPrize.getStuId() + "%");
		}
		if(Data.isValid(searchPrize.getStuName())){
			criteria.andStuNameLike("%" + searchPrize.getStuName() + "%");
		}
		if(Data.isValid(searchPrize.getPrizeClass())){
			criteria.andPrizeClassLike("%" + searchPrize.getPrizeClass() + "%");
		}
		if(Data.isValid(searchPrize.getPrizeLevel())){
			criteria.andPrizeLevelEqualTo(searchPrize.getPrizeLevel());
		}
		if(Data.isValid(searchPrize.getPrizeLevel2())){
			criteria.andPrizeLevel2EqualTo(searchPrize.getPrizeLevel2());
		}

		/*获奖时间筛选*/
		if(Data.isValid(searchPrize.getPrizeDateBegin()) && Data.isValid(searchPrize.getPrizeDateEnd())){
			criteria.andPrizeDateBetween(searchPrize.getPrizeDateBegin(), searchPrize.getPrizeDateEnd());
		}else if(Data.isValid(searchPrize.getPrizeDateBegin())){
			criteria.andPrizeDateGreaterThanOrEqualTo(searchPrize.getPrizeDateBegin());
		}else if(Data.isValid(searchPrize.getPrizeDateEnd())){
			criteria.andPrizeDateLessThanOrEqualTo(searchPrize.getPrizeDateEnd());
		}

		/*提交时间筛选*/
		if(Data.isValid(searchPrize.getSubmitDateBegin()) && Data.isValid(searchPrize.getSubmitDateEnd())){
			criteria.andSubmitDateBetween(searchPrize.getSubmitDateBegin(), searchPrize.getSubmitDateEnd());
		}else if(Data.isValid(searchPrize.getSubmitDateBegin())){
			criteria.andSubmitDateGreaterThanOrEqualTo(searchPrize.getSubmitDateBegin());
		}else if(Data.isValid(searchPrize.getSubmitDateEnd())){
			criteria.andSubmitDateLessThanOrEqualTo(searchPrize.getSubmitDateEnd());
		}

		/*审核时间筛选*/
		if(Data.isValid(searchPrize.getReviewDateBegin()) && Data.isValid(searchPrize.getReviewDateEnd())){
			criteria.andReviewDateBetween(searchPrize.getReviewDateBegin(), searchPrize.getReviewDateEnd());
		}else if(Data.isValid(searchPrize.getReviewDateBegin())){
			criteria.andReviewDateGreaterThanOrEqualTo(searchPrize.getReviewDateBegin());
		}else if(Data.isValid(searchPrize.getReviewDateEnd())){
			criteria.andReviewDateLessThanOrEqualTo(searchPrize.getReviewDateEnd());
		}

		return startSelect(example);
	}

	private PageBean<Studentsprize> startSelect(StudentsprizeExample example){
		Page<Studentsprize> page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
		PageBean<Studentsprize> studentsprizePageBean = new PageBean<Studentsprize>(studentsprizeMapper.selectByExample(example));
		studentsprizePageBean.setTotal(page.getTotal());
		studentsprizePageBean.setCurrPage(page.getPageNum());
		studentsprizePageBean.setPageSize(page.getPageSize());
		studentsprizePageBean.setPages(page.getPages());
		return studentsprizePageBean;
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
		studentsprize.setReviewDate(date);
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
