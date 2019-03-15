package com.students.controller;

import java.util.List;

import com.students.bean.Studentsinfo;
import com.students.utils.Pagination.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.students.bean.Msg;
import com.students.service.StudentsinfoService;

@Component
@Controller
@CrossOrigin
public class StudentsinfoController {

    @Autowired
    private StudentsinfoService studentsinfoService;

    /**
     * 删除学生信息，批量删除和单个删除合并
     * 批量删除：中的stuId传入遵循格式 1-2-3 否则为单个删除
     * @param stuId
     *
     * @return
     */
    /**
     * @param stuId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Studentsinfos/{stuId}", method = RequestMethod.DELETE)
    //
    public Msg deleteStudentsinfos(@PathVariable("stuId") String stuId) {

        System.out.println("delete");

        if (stuId.contains("-")) {
            String[] del_ids = stuId.split("-");
            for (String id : del_ids) {
                studentsinfoService.deleteStuInfo(id);
            }

        } else {
            studentsinfoService.deleteStuInfo(stuId);

        }
        return Msg.success();
    }

    /**
     * 实现通过ID查询某个同学的信息
     *
     * @param stuId
     * @param msg
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/Studentsinfo/{stuId}", method = RequestMethod.GET)
    public Msg getStudentsinfo(@PathVariable("stuId") String stuId, Msg msg) {

        Studentsinfo si = new Studentsinfo();
        List<Studentsinfo> list = studentsinfoService.getOne(stuId);

        return Msg.success().add("list", list);
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsinfos", method = RequestMethod.GET)
    public Msg getStudentsinfos() {
        PageBean<Studentsinfo> pageBean = studentsinfoService.getByPage();
        return Msg.success().add("pageBean", pageBean);
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsinfos/_search", method = RequestMethod.POST)
    public Msg searchStudentsinfos(@RequestBody Studentsinfo studentsinfo) {
        PageBean<Studentsinfo> pageBean = studentsinfoService.searchByPage(studentsinfo);
        return Msg.success().add("pageBean", pageBean);
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsinfos", method = RequestMethod.PUT)
    public Msg updateStudentsinfo(@RequestBody Studentsinfo studentsinfo) {

        studentsinfoService.updateStudentsinfo(studentsinfo);

        return Msg.success();
    }

    /**
     * 用于管理员创建用户，默认密码为学号。当返回失败信息时，该用户已被创建。
     *
     * @param stuId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/Studentsinfos/{stuId}", method = RequestMethod.POST)
    public Msg addStudentsinfo(@PathVariable String stuId) {
        if (studentsinfoService.addStudentsinfo(stuId)) {
            return Msg.success();
        }
        return Msg.fail();
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsinfos", method = RequestMethod.POST)
    public Msg saveStudentsinfo(@RequestBody Studentsinfo studentsinfo) {

        if (studentsinfoService.insert(studentsinfo)) {

            Msg.success();
        }
        return Msg.fail();

    }
}
