package com.students.controller;

import com.students.bean.Msg;
import com.students.service.PaperService;
import com.students.service.StudentsorgService;
import com.students.service.StudentsprizeService;
import com.students.utils.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin
public class ReviewController {
    @Autowired
    private StudentsprizeService studentsprizeService;

    @Autowired
    private StudentsorgService studentsorgService;

    @Autowired
    private PaperService paperService;

    @ResponseBody
    @RequestMapping(value = "/reviewList", method = RequestMethod.GET)
    public Msg getReviewList(){
        HashMap<String, List> map = new HashMap<String, List>();
        map.put("prizeList", studentsprizeService.getAll(Data.unReviewed.toString()));
        map.put("orgList", studentsorgService.getAll(Data.unReviewed));
        map.put("paperList", paperService.getAll(Data.unReviewed));
        return Msg.success().add("list", map);
    }
}
