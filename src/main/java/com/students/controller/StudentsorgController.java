package com.students.controller;

import java.io.IOException;
import java.util.List;

import com.students.bean.SearchOrg;
import com.students.bean.Studentsorg;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.students.bean.Msg;
import com.students.service.StudentsorgService;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.OSEnvironment;

@Controller
@CrossOrigin
public class StudentsorgController {

    @Autowired
    private StudentsorgService studentsorgService;

    /**
     * @Description:
     * @Param: studentsOrgString
     * @Param: file
     * @Return: com.students.bean.Msg
     * @author: zxy
     * @create: 2019/4/9 22:45
     **/
    @ResponseBody
    @RequestMapping(value = "/Studentsorg", method = RequestMethod.POST)
    public Msg addOrg(@RequestParam(value = "org") String studentsOrgString,
                      @RequestParam(value = "file") MultipartFile file) throws IOException {
        JSONObject jsonObject = JSONObject.fromObject(studentsOrgString);
        Studentsorg studentsorg = (Studentsorg) JSONObject.toBean(jsonObject, Studentsorg.class);
        /*由于前端传来的日期格式为yyyy-mm-dd，不是yyyy-mm-dd hh:mm:ss，无法通过toBean方法写入到对象中，导致日期被设置为当前时间，需要手动转换*/
        studentsorg.setOrgBegin(Data.stringToShortDate(jsonObject.get("orgBegin").toString()));
        studentsorg.setOrgEnd(Data.stringToShortDate(jsonObject.get("orgEnd").toString()));
        boolean bool = studentsorgService.addOrg(studentsorg, file);
        if (bool) {
            return Msg.success();

        }
        return Msg.fail().add("msg", "添加新的组织/活动失败");

    }


    @ResponseBody
    @RequestMapping(value = "/Studentsorg/{orgId}", method = RequestMethod.DELETE)
    public Msg deleteOrg(@PathVariable Integer orgId) {
        boolean bool = studentsorgService.deleteOrg(orgId);
        if (bool) {
            return Msg.success();
        }
        return Msg.fail().add("msg","删除失败");
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsorg/{stuId}", method = RequestMethod.GET)
    public Msg getOrg(@PathVariable String stuId) {

        List<Studentsorg> list = studentsorgService.getOrg(stuId);
        Msg msg = new Msg();
        return msg.add("list", list);
    }

    /**
     * @Description:
     * @Param: studentsOrgString
     * @Param: file
     * @Return: com.students.bean.Msg
     * @author: zxy
     * @create: 2019/4/10 9:58
     **/
    @ResponseBody
    @RequestMapping(value = "/Studentsorg/update", method = RequestMethod.POST)
    public Msg updateOrg(@RequestParam(value = "org") String studentsOrgString,
                         @RequestParam(value = "file", required = false) MultipartFile file) throws IOException{
        JSONObject jsonObject = JSONObject.fromObject(studentsOrgString);
        Studentsorg studentsorg = (Studentsorg) JSONObject.toBean(jsonObject, Studentsorg.class);
        /*由于前端传来的日期格式为yyyy-mm-dd，不是yyyy-mm-dd hh:mm:ss，无法通过toBean方法写入到对象中，导致日期被设置为当前时间，需要手动转换*/
        studentsorg.setOrgBegin(Data.stringToShortDate(jsonObject.get("orgBegin").toString()));
        studentsorg.setOrgEnd(Data.stringToShortDate(jsonObject.get("orgEnd").toString()));

        boolean bool = studentsorgService.updateOrg(studentsorg, file);
        if (bool) {
            return Msg.success();
        }
        return Msg.fail();
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsorg", method = RequestMethod.GET)
    public Msg getOrgs() {
        PageBean<Studentsorg> pageBean = studentsorgService.getAllByPage();
        return Msg.success().add("pageBean", pageBean);
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsorg/{studentId}/{status}")
    public Msg getOrgs(@PathVariable String studentId,
                       @PathVariable Integer status){
        PageBean<Studentsorg> pageBean = studentsorgService.getAllByPage(studentId, status);
        return Msg.success().add("pageBean", pageBean);
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsorg/_search", method = RequestMethod.POST)
    public Msg searchOrgs(@RequestBody SearchOrg searchOrg) {
        PageBean<Studentsorg> pageBean = studentsorgService.searchByPage(searchOrg);
        return Msg.success().add("pageBean", pageBean);
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsorg/getorg/{orgId}", method = RequestMethod.GET)
    public Msg getOrg(@PathVariable int orgId) {

        Studentsorg org = studentsorgService.getOne(orgId);
        Msg msg = new Msg();
        return msg.add("studentsorg", org);
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsorg/review", method = RequestMethod.POST)
    public Msg review(String isPassed, Integer orgId, String reason) {
        studentsorgService.review(isPassed, orgId, reason);
        return Msg.success();
    }
}
