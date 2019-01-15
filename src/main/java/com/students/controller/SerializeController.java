 package com.students.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.students.service.SerializeService;

@Controller
public class SerializeController {

	@Autowired
	private SerializeService serializeService;
	
	@GetMapping("/resume/hello")
	@ResponseBody
	public String hello() {
		return "1111";
	}
	
	@PostMapping("/resume/add")
	@ResponseBody
	public boolean addResume(@RequestParam("resume")String resume,
			@RequestParam("stuId")String stuId) throws IOException {
				return serializeService.addResume(resume,stuId);
			}
	
	
	@GetMapping("/resume/get/{stuId}")
	@ResponseBody
	public String getResume(@PathVariable String stuId) throws ClassNotFoundException, IOException {
		
		return serializeService.getResume(stuId);
		
	}
	
	@DeleteMapping("/resume/delete/{stuId}")
	@ResponseBody
	public boolean deleteResume(@PathVariable String stuId) {
		
		return serializeService.deleteResume(stuId);
		
	}
}
