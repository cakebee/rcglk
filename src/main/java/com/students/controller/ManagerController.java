 
package com.students.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.students.bean.Manager;
import com.students.bean.Msg;
import com.students.service.ManagerService;

@Controller

public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@ResponseBody
	@RequestMapping(value="/manager",method=RequestMethod.PUT)
	public Msg upadteManager( Manager manager){
		managerService.updateManager(manager);
		
		return Msg.success();
	}
	
	/**
	 * 添加管理员 需要输入编号
	 * 默认密码为编号
	 * @param managerId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/manager",method=RequestMethod.POST)
	public Msg addManager( String managerId){
		managerService.addManager(managerId);
		
		return Msg.success();
	}
	
	
	
	/**
	 * 删除管理员 包含了多个删除和单独删除 
	 * 若为多个删除：Id里包含了多个id用-连接
	 * @param managerId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/manager/{managerId}",method=RequestMethod.DELETE )
	
	public Msg deleteManager(@PathVariable String managerId){
		if(managerId.contains("-")){
			String[] managerIds=managerId.split("-");
			for(String id:managerIds){
				managerService.deleteManager(id);
				
				return Msg.success();
			}
		}
		managerService.deleteManager(managerId);
		return Msg.success();
			
		
	
	}
	
	/**
	 * 
	 * @return msg(managers)
	 */
	
	@ResponseBody
	@RequestMapping(value="/manager",method=RequestMethod.GET )
	
	public Msg getManagers(){
		List<Manager> managers=new ArrayList<Manager>();
		managers= managerService.getAll();
		Msg msg=new Msg();
		
		return msg.success().add("managers", managers);
	}
	
	@ResponseBody
	@RequestMapping(value="/manager/{managerId}",method=RequestMethod.GET )
	
	public Msg getManager(@PathVariable String managerId){
		Manager  manager= managerService.getOne("managerId");
		Msg msg=new Msg();
		
		return msg.success().add("manager", manager);
		
	}
	
	/**
	 * guan管理员通过验证邮箱来修改密码
	 * 
	 * @param managerId
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/manager/changePass",method=RequestMethod.POST )
	public Msg changePass(String managerId,String email){
		Manager manager= managerService.getOne(managerId);
		if(email.equals(manager.getManagerEmail())){
			return Msg.success();
		}
		return Msg.fail();
	}
	
	
	
	
	
	
	
	
	
	
	

}
