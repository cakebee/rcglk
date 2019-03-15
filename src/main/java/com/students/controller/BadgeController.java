package com.students.controller;

import com.students.bean.Msg;
import com.students.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class BadgeController {

    @Autowired
    BadgeService badgeService;

    @ResponseBody
    @RequestMapping(value = "/Badge")
    public Msg getAllBadge(){
        return Msg.success().add("map", badgeService.getAllBadge());
    }
}
