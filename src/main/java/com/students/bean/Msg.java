package com.students.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//code 状态码  成功：100
	//            失败：200
	private int code;
	private Map<String,Object> extend=new HashMap<String,Object>();
	
	/*
	 * 添加返回的信息
	 */
	
	public Msg add(String name,Object value){
		this.getExtend().put(name, value);
		
		return this;
		
		
	}
	
	public static Msg fail(){
		Msg msg=new Msg();
		msg.setCode(200);
		return msg;
		
	}
	
	public static Msg success(){
		Msg msg=new Msg();
		msg.setCode(100);
		
		return msg;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	

}
