package com.students.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.students.service.ExcelService;

@Controller
@CrossOrigin
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;
	
	
	
	@ResponseBody
	@RequestMapping(value="/Excel/{read}",method=RequestMethod.POST)
	public void readGrade(MultipartFile file,@PathVariable("read") String read) throws ParseException{
		
		
		String oriName=file.getOriginalFilename();
		
		File savePath= new File("/data/wwwroot/default/rcglk/excel/"+oriName);
		//File savePath= new File("D://"+oriName);
		//File savePath=new File("D:/"+oriName);
		System.out.println(read);
		try {
			file.transferTo(savePath);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(read.equals("readGrade")) {
		excelService.readGrade(savePath.toString());
		}else if(read.equals("readInfo")) {
			excelService.readInfo(savePath.toString());
		}else if(read.equals("readPrize")) {
			excelService.readPrize(savePath.toString());
		}else {
			excelService.readOrg(savePath.toString());
	
		}
		
		
		
		
		savePath.delete();
		
		
		
		
	}
	
	
		
		
	
	
	

}
