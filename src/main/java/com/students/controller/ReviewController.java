package com.students.controller;

import com.students.bean.Msg;
import com.students.bean.Project;
import com.students.service.PaperService;
import com.students.service.ProjectService;
import com.students.service.StudentsorgService;
import com.students.service.StudentsprizeService;
import com.students.utils.Data;
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
    private StudentsprizeService studentsprizeService;
    private StudentsorgService studentsorgService;
    private PaperService paperService;
    private ProjectService projectService;

    public ReviewController(StudentsprizeService studentsprizeService, StudentsorgService studentsorgService, PaperService paperService, ProjectService projectService) {
        this.studentsprizeService = studentsprizeService;
        this.studentsorgService = studentsorgService;
        this.paperService = paperService;
        this.projectService = projectService;
    }

    @ResponseBody
    @RequestMapping(value = "/reviewList", method = RequestMethod.GET)
    public Msg getReviewList(){
        HashMap<String, List> map = new HashMap<String, List>();
        Project project = new Project();
        project.setStatus(Data.unReviewed);

        map.put("prizeList", studentsprizeService.getAll(Data.unReviewed.toString()));
        map.put("orgList", studentsorgService.getAll(Data.unReviewed));
        map.put("paperList", paperService.getAll(Data.unReviewed));
        map.put("projectList", projectService.listProjects(project));

        return Msg.success().add("list", map);
    }
}
