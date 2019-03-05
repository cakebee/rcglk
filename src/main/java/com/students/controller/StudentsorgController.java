package com.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.students.bean.Msg;
import com.students.bean.Studentsorg;
import com.students.service.StudentsorgService;
import com.students.service.StudentsprizeService;

@Controller
@CrossOrigin
public class StudentsorgController {
	
	@Autowired
	private StudentsorgService studentsorgService;
	
	/**
	 * 
	 * @param studentsorg
	 * @return MSG
	 */
	@ResponseBody
	@RequestMapping(value="/Studentsorg",method=RequestMethod.POST)
	public Msg addOrg(@RequestBody Studentsorg studentsorg){
		
		boolean bool=studentsorgService.addOrg(studentsorg);
		if(bool){
			return Msg.success();
			
			}
			return Msg.fail();
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/Studentsorg/{stuId}",method=RequestMethod.DELETE)
	
	public Msg deleteOrg(@PathVariable String stuId){
		boolean bool=studentsorgService.deleteOrg(stuId);
		if(bool){
		return Msg.success();
		
		}
		return Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/Studentsorg/{stuId}",method=RequestMethod.GET)
	public Msg getOrg(@PathVariable String stuId){
		
		List<Studentsorg> list=studentsorgService.getOrg(stuId);
		Msg msg=new Msg();
		return msg.add("list", list);
	}
	
	@ResponseBody
	@RequestMapping(value="/Studentsorg",method=RequestMethod.PUT)
	public Msg updateOrg(@RequestBody Studentsorg studentsorg){
		boolean bool=studentsorgService.saveOrg(studentsorg);
		if(bool){
		return Msg.success();
		}
		return Msg.fail();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/Studentsorg",method=RequestMethod.GET)
	public Msg getOrgs(){
		
		List<Studentsorg> list=studentsorgService.getAll();
		Msg msg=new Msg();
		msg.setCode(100);
		return msg.add("list", list);
	}
	
	@ResponseBody
	@RequestMapping(value="/Studentsorg/getorg/{orgId}",method=RequestMethod.GET)
	public Msg getOrg(@PathVariable int orgId){
		
		Studentsorg org=studentsorgService.getOne(orgId);
		Msg msg=new Msg();
		return msg.add("studentsorg",org);
	}
	
	

}
