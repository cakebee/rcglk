package com.students.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.students.bean.Studentsinfo;
import com.students.mapper.StudentsinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.students.bean.Msg;
import com.students.service.ManagerService;
import com.students.service.StudentsinfoService;

/**
 * 实现了登陆验证的控制器,geng根据传入的参数的名字的区别来判断是用户还是管理员
 * @author Fate
 *
 */
@Controller
@CrossOrigin
public class LoginController {
	
	@Autowired
	private StudentsinfoService studentsinfoService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private StudentsinfoMapper infoMapper;
	
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Msg login(HttpServletRequest request,String username,String password){
		
		HttpSession session=request.getSession();
		Msg msg=new Msg();
		
		if(username!=null){
			if(username.equals("tingjie")&&password.equals("wozuibang")){
				session.setAttribute("username", username);
				msg.add("user", "manager").setCode(200);;
				return msg;
				
			}
			if(studentsinfoService.isStudent(username,password)){
				session.setAttribute("username", username);
			    
				msg.add("user", "student").setCode(200);
				Studentsinfo info=infoMapper.selectByPrimaryKey(username);
				String stuName=info.getStuName();
				msg.add("stuName", stuName);
				
				return msg;
			}else if(managerService.isManager(username,password)){
				session.setAttribute("username", username);
				
				msg.add("user", "manager").setCode(200);
				
				return msg;
			}
			
			
		}
		
		
	    String massage="账号或密码错误";
	    session.setAttribute("massage", massage);
		//否则 登录失败  返回登陆页面
	    msg.setCode(100);
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/loginout")
	public void loginout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		
		if( session.getAttribute("username")!=null) {
			session.removeAttribute("username");
		}
	}
	
	

}
