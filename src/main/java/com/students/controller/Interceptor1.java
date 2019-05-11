package com.students.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor{

	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		if(arg0.getRequestURI().contains("login")){
			
			System.out.println("login");
			return true;
			
		}
		HttpSession session= arg0.getSession();
		
		if(session.getAttribute("username")!=null){
			
			return true;
		}
		//璺宠浆鍒扮櫥闄嗙晫闈㈣繘琛岀櫥闄�
		//arg1.sendRedirect("WEB-INF/views/login.jsp");
		
		arg0.getRequestDispatcher("login.html").forward(arg0, arg1);
		
		
		
		
		return false;
	}

}
