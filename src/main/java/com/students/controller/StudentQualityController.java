package com.students.controller;

import com.students.bean.Msg;
import com.students.bean.Studentsquality;
import com.students.service.StudentQualityService;
import com.students.service.StudentsinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin
public class StudentQualityController {

    @Autowired
    private StudentQualityService studentQualityService;

    //使用训练数据构建决策树
    @ResponseBody
    @RequestMapping(value = "/DTree", method = RequestMethod.GET)
    public Msg createDecisonTree(){

        if(!studentQualityService.createTree()){
            System.out.println("FAIL: Create Tree");
            return Msg.fail();
        }
        System.out.println("SUCCESS: Create Tree");
        return Msg.success();
    }

    //获取分类后的学生综合素质评价结果
    @ResponseBody
    @RequestMapping(value = "/StudentQuality", method = RequestMethod.GET)
    public Msg getStudentQuality(){
        List<Studentsquality> studentsQualityList = studentQualityService.getAll();
        return Msg.success().add("studentQualityList", studentQualityService.transData(studentsQualityList));
    }

    //重新构建决策树、收集学生数据并计算学生综合评价
    @ResponseBody
    @RequestMapping(value = "/RefreshStudentQuality", method = RequestMethod.GET)
    public Msg calculate(){
        createDecisonTree();
        HashMap<String, HashMap<String, String>> data = studentQualityService.collectData();
        studentQualityService.analyseData(data);
        studentQualityService.saveData(data);
        List<Studentsquality> studentsQualityList = studentQualityService.getAll();
        return Msg.success().add("studentQualityList", studentQualityService.transData(studentsQualityList));
    }
}
