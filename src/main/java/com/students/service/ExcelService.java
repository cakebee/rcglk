package com.students.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.interceptor.AroundTimeout;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.students.bean.Grade;
import com.students.bean.Studentsinfo;
import com.students.bean.Studentsorg;
import com.students.bean.Studentspass;
import com.students.bean.Studentsprize;
import com.students.mapper.GradeMapper;
import com.students.mapper.StudentsinfoMapper;
import com.students.mapper.StudentsorgMapper;
import com.students.mapper.StudentspassMapper;
import com.students.mapper.StudentsprizeMapper;


@Service
public class ExcelService {
	
	
@Autowired
private GradeMapper gradeMapper;

@Autowired
private StudentsinfoMapper infoMapper;

@Autowired
private StudentsprizeMapper prizeMapper;

@Autowired
private StudentsorgMapper orgMapper;

@Autowired
private StudentspassMapper passMapper;

    public void readInfo(String filePath) {
    	 String c[]= {"stuId","stuName","stuGender","identity","stuMajor","stuGrade",
         		"stuClass","stuDorm","stuStatus","password"};
    	 List<Map<String,String>> list=read(filePath,c);
    	 Studentsinfo info=new Studentsinfo();
    	 Studentspass pass=new Studentspass();
         for (Map<String,String> map : list) {
              info.setStuId(map.get("stuId"));
              pass.setStuId(map.get("stuId"));
              info.setStuName(map.get("stuName"));
              info.setStuGender(map.get("stuGender"));
              info.setIdentity(map.get("identity"));
              info.setStuMajor(map.get("stuMajor"));
              info.setStuGender(map.get("stuGrade"));
              info.setStuClass(map.get("stuClass"));
              info.setStuDorm(map.get("stuDorm"));
              
              info.setStuStatus(map.get("stuStatus"));
              pass.setStuPsw(map.get("password"));
              
              infoMapper.insert(info);
             
              passMapper.insert(pass);
              
         }
         
         

    }
    
    public void readGrade(String filePath) {
    	
    	String columns[] = {"stuId","name","point","grade"};
        List<Map<String,String>> list=read(filePath,columns);
        Grade grade=new Grade();
        for (Map<String,String> map : list) {
        	
        	String stuId= map.get("stuId");
        	String stuName=map.get("name");
        	String s=map.get("point").trim();
        	float point=Float.parseFloat(s);
        	int gra=Integer.parseInt(map.get("grade"));
        	
            grade.setStuId(stuId);
        	grade.setStuName(stuName);
        	grade.setAvgPonit(point);
        	grade.setAvrGrade(gra);
        	
        	gradeMapper.insert(grade);
        }
    	
    }
    
    public void readPrize(String filePath) throws ParseException {
   	 String c[]= {"stuId","stuName","prizeName","prizeClass","prizeLevel",
   			 "prizeDate","prizeIntro"};
 	 List<Map<String,String>> list=read(filePath,c);
 	 Studentsprize prize= new  Studentsprize();
 	 SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
      for (Map<String,String> map : list) {
          prize.setStuId(map.get("stuId"));
          prize.setStuName(map.get("stuName"));
          prize.setPrizeName(map.get("prizeName"));
          prize.setPrizeClass(map.get("prizeClass"));
          prize.setPrizeLevel(map.get("prizeLevel"));
          
          Date date=df.parse(map.get("prizeDate"));
          prize.setPrizeDate(date);
          prize.setStatus("0");
          prize.setPrizeIntro(map.get("prizeIntro"));
          System.out.println(map.get("prizeIntro"));
          prizeMapper.insert(prize);
          
      }
    }
    
    public void readOrg(String filePath) throws ParseException {
      	 String[] c= {"stuId","stuName","orgName","orgClass","orgDuty","beginDate",
      			 "endDate","orgIntro"};
    	 List<Map<String,String>> list=read(filePath,c);
    	 Studentsorg org=new Studentsorg();
    	 DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
         for (Map<String,String> map : list) {
            org.setStuId(map.get("stuId"));
            org.setStuName(map.get("stuName"));
            org.setOrgName(map.get("orgName"));
            org.setOrgClass(map.get("orgClass")); 
            org.setOrgDuty(map.get("orgDuty"));
            
            Date d1=df.parse(map.get("beginDate"));
            Date d2=df.parse(map.get("endDate"));
            org.setOrgBegin(d1);
            org.setOrgEnd(d2);
            org.setOrgIntro(map.get("orgIntro"));
            orgMapper.insert(org);
            System.out.println(org);
         }
       }
	
    /**
     * 
     * @param filePath 表格的路径
     * @param columns   表格数据对应的字段 ，顺序需要和表格从左至右的顺序一样
     * @return 返回了 以 字段名为键值，字段值 为值的MAP型链表。
     */

    public List<Map<String,String>>  read(String filePath,String columns[]) {
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String, String>> list = null;
        String cellData = null;

        wb = readExcel(filePath);
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<Map<String,String>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数 
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                Map<String,String> map = new LinkedHashMap<String,String>();
                row = sheet.getRow(i);
                if(row !=null){
                    for (int j=0;j<colnum;j++){
                        cellData =   getCellFormatValue(row.getCell(j));
                        map.put(columns[j], cellData);
                    }
                }else{
                    break;
                }
                list.add(map);
            }
        }
        
        return list;
       
    }
    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try { is = new FileInputStream(filePath);
        if(".xls".equals(extString)){
            return wb = new HSSFWorkbook(is);
        }else if(".xlsx".equals(extString)){
            return wb = new XSSFWorkbook(is);
        }else{
            return wb = null;
        }
        
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return wb;
}
@SuppressWarnings("deprecation")
public static String getCellFormatValue(Cell cell){
	 String cellValue = "";  
     if(cell == null){  
         return cellValue;  
     }  
     
     
     //把数字当成String来读，避免出现1读成1.0的情况  
     if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){  
    	 
    	 if(String.valueOf(cell.getNumericCellValue()).indexOf("E")!=-1){
    	      
    	        return new DecimalFormat("#").format(cell.getNumericCellValue());
    	    }
    	 if(HSSFDateUtil.isCellDateFormatted(cell)) {

        	 Date d=cell.getDateCellValue();
        	 //如果是时间，则转为yyyy-MM-dd的格式。可以根据自己的需要转化
        	 DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        	 cellValue=df.format(d);
        	 return cellValue;
    	 }
        
     } 
 
       switch (cell.getCellType()){  
         case Cell.CELL_TYPE_NUMERIC: //数字  
             cellValue = String.valueOf(cell.getNumericCellValue());  
             break;  
         case Cell.CELL_TYPE_STRING: //字符串  
             cellValue = String.valueOf(cell.getStringCellValue());  
             break;  
         case Cell.CELL_TYPE_BOOLEAN: //Boolean  
             cellValue = String.valueOf(cell.getBooleanCellValue());  
             break;  
         case Cell.CELL_TYPE_FORMULA: //公式  
             cellValue = String.valueOf(cell.getCellFormula());  
             
             break;  
         
         case Cell.CELL_TYPE_BLANK: //空值   
             cellValue = "";  
             break;  
         case Cell.CELL_TYPE_ERROR: //故障  
             cellValue = "非法字符";  
             break;  
         default:  
             cellValue = "未知类型";  
             break;  
     }  
     
     cellValue=cellValue.replace(".0", "");
     return cellValue; 
}


   

}
