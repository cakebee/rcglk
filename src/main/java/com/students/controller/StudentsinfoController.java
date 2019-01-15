package com.students.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.students.bean.Msg;
import com.students.bean.Studentsinfo;
import com.students.service.StudentsinfoService;

@Component
@Controller
public class StudentsinfoController {
	
	@Autowired
	private StudentsinfoService studentsinfoService;
	
	/**
	 * 删除学生信息，批量删除和单个删除合并
	 * 批量删除：中的stuId传入遵循格式 1-2-3 否则为单个删除
	 * @param stuId
	 * 
	 * @return
	 */
	/**
	 * 
	 * @param stuId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/Studentsinfos/{stuId}", method=RequestMethod.DELETE)
	//
	public Msg deleteStudentsinfos(@PathVariable("stuId")  String stuId){
		
		System.out.println("delete");
		
		if(stuId.contains("-")){
			String[] del_ids=stuId.split("-");
			for(String id:del_ids){
				studentsinfoService.deleteStuInfo(id);
				}
			
		}else{
			studentsinfoService.deleteStuInfo(stuId);
			
		}
		return Msg.success();
	}
	/**
	 * 实现通过ID查询某个同学的信息
	 * @param stuId
	 * @param msg
	 * @return
	 */
	 
	@ResponseBody
	@RequestMapping(value="/Studentsinfos/{stuId}", method=RequestMethod.GET)
	public Msg getStudentsinfo(@PathVariable("stuId")  String stuId,Msg msg){

		Studentsinfo si=new Studentsinfo();
		List<Studentsinfo> list=studentsinfoService.getOne(stuId);
		
		
		
		return msg.success().add("list", list);
	}
	
	@ResponseBody
	@RequestMapping(value="/Studentsinfos",method=RequestMethod.GET)
	public Msg getStudentsinfos(){
		
		
		
		List<Studentsinfo> list=new ArrayList<Studentsinfo>();
		list=studentsinfoService.getAll();
		
		Msg msg=new Msg();
		
		
		return msg.success().add("liat", list);
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/Studentsinfos",method=RequestMethod.PUT )
	public Msg updateStudentsinfo( @RequestBody Studentsinfo studentsinfo){
		
		studentsinfoService.updateStudentsinfo(studentsinfo);
		
		
		
		
		return Msg.success();
		
	}
	
	/**
	 * 用于管理员创建用户，默认密码为学号。当返回失败信息时，该用户已被创建。
	 * @param stuId
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value="/Studentsinfos/{stuId}",method=RequestMethod.POST)
	public Msg addStudentsinfo(@PathVariable String stuId){
		if(studentsinfoService.addStudentsinfo(stuId)){
			return Msg.success();
		}
		return Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/Studentsinfos",method=RequestMethod.POST)
	public Msg  saveStudentsinfo(@RequestBody Studentsinfo studentsinfo){
		
		if(studentsinfoService.insert(studentsinfo))
		{
		
		Msg.success();
		}
		return Msg.fail();
		
	}
	
	

}
