package com.students.controller;

import com.students.bean.Msg;
import com.students.bean.Project;
import com.students.bean.SearchProject;
import com.students.service.ProjectService;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import net.sf.json.JSONObject;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author zxy
 * @project rcglk
 * @description 管理学生项目
 * @email zxy@nmzl.cc
 * @date 2019-04-15-10:00
 **/
@Controller
@CrossOrigin
@RequestMapping(value = "/project")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * 预处理项目project表单，将传来的json字符串转化为project对象，并验证其有效性
     * @param projectString 项目project的json字符串
     * @param project 用于接收转化后的project对象
     * @return java.lang.String
     * @author zxy
     * @create 2019/4/15 21:27
     **/
    private String preHandler(String projectString, Project project){
        if(!Data.isValid(projectString)) {
            return "表单为空";
        }
        Calendar calendar = Calendar.getInstance();
        BeanCopier copier = BeanCopier.create(project.getClass(), project.getClass(), false);
        JSONObject jsonObject = JSONObject.fromObject(projectString);
        Project newProject = (Project) JSONObject.toBean(jsonObject, Project.class);
        copier.copy(newProject, project, null);
        project.setStartDate(Data.stringToShortDate(jsonObject.get("startDate").toString()));
        project.setEndDate(Data.stringToShortDate(jsonObject.get("endDate").toString()));
        project.setSubmitDate(calendar.getTime());
        /*验证数据*/
        Set<ConstraintViolation<Project>> set =  Data.validator.validate(newProject);
        if(!set.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (ConstraintViolation<Project> c : set) {
                msg.append(c.getMessage());
                msg.append('，');
            }
            msg.delete(msg.length()-1, msg.length());
            return msg.toString();
        }
        return null;
    }


    /**
     * 根据学生id和审核状态获取项目project列表
     * @param stuId 学生id
     * @param status 审核状态
     * @param isPage 是否分页
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/15 22:06
     **/
    @ResponseBody
    @RequestMapping(value = "/{stuId}/{status}", method = RequestMethod.GET)
    public Msg listProjects(@PathVariable(value = "stuId") String stuId,
                            @PathVariable(value = "status") Integer status,
                            @RequestParam(value = "isPage") boolean isPage) {
        Project project = new Project();
        if (!Data.isValid(stuId)) {
            return Msg.fail().add("msg", "学号为空");
        }
        if (!Data.isValid(status)) {
            return Msg.fail().add("msg", "状态为空");
        }
        project.setStuId(stuId);
        project.setStatus(status);

        if(isPage){
            PageBean<Project> projectPageBean = projectService.listProjectsByPage(project);
            if(projectPageBean != null){
                return Msg.success().add("pageBean", projectPageBean);
            }
        }else {
            List<Project> projectList = projectService.listProjects(project);
            if(projectList != null){
                return Msg.success().add("list", projectList);
            }
        }
        return Msg.fail().add("msg", "获取项目失败");
    }

    /**
     * 根据学生id获取项目project列表
     * @param stuId 学生id
     * @param isPage 是否分页
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/15 22:05
     **/
    /*@ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg listProjects(@RequestParam(value = "stuId")String stuId,
                            @RequestParam(value = "isPage")boolean isPage){
        if(!Data.isValid(stuId)){
            return Msg.fail().add("msg", "学号为空");
        }
        Project project = new Project();
        project.setStuId(stuId);
        if(isPage){
            PageBean<Project> projectPageBean = projectService.listProjectsByPage(project);
            if(projectPageBean != null){
                return Msg.success().add("pageBean", projectPageBean);
            }
        }else {
            List<Project> projectList = projectService.listProjects(project);
            if(projectList != null){
                return Msg.success().add("list", projectList);
            }
        }
        return Msg.fail().add("msg", "获取项目失败");
    }*/

    /**
     * 根据状态获取项目project列表
     * @param status 审核状态
     * @param isPage 是否分页
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/15 22:04
     **/
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Msg listProjects(@RequestParam(value = "status")Integer status,
                            @RequestParam(value = "isPage")boolean isPage){
        if(!Data.isStatusValid(status)){
            return Msg.fail().add("msg", "状态不存在");
        }
        Project project = new Project();
        project.setStatus(status);
        if(isPage){
            PageBean<Project> projectPageBean = projectService.listProjectsByPage(project);
            if(projectPageBean != null){
                return Msg.success().add("pageBean", projectPageBean);
            }
        }else {
            List<Project> projectList = projectService.listProjects(project);
            if(projectList != null){
                return Msg.success().add("list", projectList);
            }
        }
        return Msg.fail().add("msg", "获取项目失败");
    }

    /**
     * 添加一个项目project
     * @param projectString 被转换成json字符串的project对象
     * @param file （可选）证明文件
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/15 20:51
     **/
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addProject(@RequestParam(value = "project")String projectString,
                          @RequestParam(value = "file", required = false)MultipartFile file){
        Project project = new Project();
        /*预处理数据*/
        String msg = preHandler(projectString, project);
        System.out.println(projectString);
        System.out.println(project.getName());
        System.out.println(project.getStuId());
        if(msg != null){
            return Msg.fail().add("msg", msg);
        }
        if (projectService.addProject(project, file)) {
            return Msg.success();
        }
        return Msg.fail().add("msg", "添加失败");
    }

    /**
     * 更新项目project信息
     * @param projectString 被转换成json字符串的project对象
     * @param file （可选）证明文件
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/15 21:18
     **/
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Msg updateProject(@RequestParam(value = "project")String projectString,
                             @RequestParam(value = "file")MultipartFile file){
        if(!Data.isValid(projectString)) {
            return Msg.fail().add("msg", "项目表单为空");
        }
        Project project = new Project();
        /*预处理数据*/
        String msg = preHandler(projectString, project);
        if (msg != null) {
            return Msg.fail().add("msg", msg);
        }
        if (projectService.updateProject(project, file)) {
            return Msg.success();
        }
        return Msg.fail().add("msg", "添加失败");
    }

    /**
     * 获取一个项目project
     * @param id 项目id
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/15 21:23
     **/
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Msg getProject(@PathVariable(value = "id")String id){
        if(!Data.isValid(id)){
            return Msg.fail().add("msg", "参数为空");
        }
        Project project = projectService.getProject(id);
        if(project == null){
            return Msg.fail().add("msg", "没有找到该项目");
        }
        return Msg.success().add("project", project);
    }

    /**
     * 删除一个项目project
     * @param id 项目id
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/15 21:26
     **/
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Msg deleteProject(@PathVariable(value = "id")String id){
        if(!Data.isValid(id)){
            return Msg.fail().add("msg", "参数为空");
        }
        if(!projectService.deleteProject(id)){
            return Msg.fail().add("msg", "删除项目失败");
        }
        return Msg.success();
    }


    /**
     * 搜索项目
     * @param project 搜索内容表单
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/18 10:58
     **/
    @ResponseBody
    @RequestMapping(value = "/_search", method = RequestMethod.POST)
    public Msg searchProject(@RequestBody SearchProject project){
        if(project == null){
            return Msg.fail().add("msg", "参数为空");
        }
        PageBean<Project> projectPageBean = projectService.listAlikeProjectsByPage(project);
        if(projectPageBean == null){
            return Msg.fail().add("msg", "搜索项目失败");
        }
        return Msg.success().add("pageBean", projectPageBean);
    }

    /**
     * 审核项目project
     * @param isPass 是否通过，取值"pass"和"unPass"
     * @param projectId 需要审核的项目project的id
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/23 15:45
     **/
    @ResponseBody
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Msg reviewProject(@RequestParam("isPassed")String isPass,
                             @RequestParam("id")String projectId,
                             @RequestParam(value = "reason", required = false)String reason){
        if(isPass == null || projectId == null){
            return Msg.fail().add("msg", "缺少参数");
        }

        if(projectService.reviewProject(projectId, isPass, reason)){
            return Msg.success();
        }else {
            return Msg.fail().add("msg","更新该项目的状态失败");
        }
    }
}
