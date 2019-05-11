package com.students.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.Project;
import com.students.bean.ProjectExample;
import com.students.mapper.ProjectMapper;
import com.students.utils.Data;
import com.students.utils.FileOp;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import com.students.utils.Path;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author zxy
 * @project rcglk
 * @description 学生项目管理服务
 * @email zxy@nmzl.cc
 * @date 2019-04-14-11:30
 **/
@Service
public class ProjectService {
    private ProjectMapper projectMapper;

    public ProjectService(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    /**
     * 添加一个项目，插入成功返回true，失败返回false。
     * @param project 待插入的项目
     * @param file 证明文件，可为空
     * @return boolean
     * @author zxy
     * @create 2019/4/14 15:52
     **/
    public boolean addProject(Project project, MultipartFile file) {
        String id = UUID.randomUUID().toString().replace("-", "");
        File savedFile;
        project.setId(id);
        project.setStatus(Data.unReviewed);

        /*不带证明文件的记录插入*/
        if(file == null) {
            return projectMapper.insert(project) == 1;
        }

        /*带证明文件的记录插入*/
        try {
            savedFile = FileOp.save(file, Path.org);
        }catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }
        project.setFile(savedFile.getName());
        return projectMapper.insert(project) == 1;
    }

    /**
     * 更新项目、证明文件
     * @param project 待更新的项目
     * @param file 待存储的证明文件，可为空
     * @return boolean
     * @author zxy
     * @create 2019/4/14 16:41
     **/
    public boolean updateProject(Project project, MultipartFile file) {
        File savedFile;
        Project oldProject;

        /*该主键不存在*/
        if(project.getId() != null) {
            oldProject = projectMapper.selectByPrimaryKey(project.getId());
        } else {
            return false;
        }

        /*不带证明文件的记录更新*/
        if(file == null) {
            return projectMapper.updateByPrimaryKeySelective(project) == 1;
        }

        /*带证明文件的记录更新*/
        try{
            savedFile = FileOp.save(file, Path.proj);
        }catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }
        /*删除旧文件*/
        if(oldProject.getFile() != null) {
            if(!FileOp.delete(Path.proj + oldProject.getFile())){
                return false;
            }
        }
        project.setFile(savedFile.getName());
        project.setStatus(Data.unReviewed);
        return projectMapper.updateByPrimaryKeySelective(project) == 1;
    }

    /**
     * 删除项目记录以及证明文件，失败后回滚
     * @param id 待删除的项目id
     * @return boolean
     * @author zxy
     * @create 2019/4/14 17:15
     **/
    public boolean deleteProject(String id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        if(project == null) {
            return false;
        }

        /*删除记录失败*/
        if(projectMapper.deleteByPrimaryKey(id) != 1) {
            return false;
        }

        /*文件删除失败，重新插入记录*/
        if(!FileOp.delete(Path.proj + project.getFile())){
            projectMapper.insert(project);
            return false;
        }

        return true;
    }

    /**
     * 通过id获取对应的一个项目
     * @param id 项目id
     * @return com.students.bean.Project
     * @author zxy
     * @create 2019/4/14 17:20
     **/
    public Project getProject(String id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取数据库中所有的项目
     * @description 获取数据库中所有的项目
     * @return java.util.List<com.students.bean.Project>
     * @author zxy
     * @create 2019/4/14 17:21
     **/
    @Deprecated
    public List<Project> listProjects() {
        return projectMapper.selectByExample(null);
    }

    /**
     * 根据某些属性查询项目，支持的属性请查看getProjectExample()
     * @param project 需要查询的属性值装在project对象中
     * @return java.util.List<com.students.bean.Project>
     * @author zxy
     * @create 2019/4/14 18:05
     **/
    public List<Project> listProjects(Project project) {
        ProjectExample example = getProjectExample(project);
        return projectMapper.selectByExample(example);
    }

    /**
     * 以分页方式查询
     * @param example projectExample
     * @return com.students.utils.Pagination.PageBean<com.students.bean.Project>
     * @author zxy
     * @create 2019/4/14 19:54
     **/
    private PageBean<Project> startSelectByPage(ProjectExample example) {
        Page<Project> page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        List<Project> projectList = projectMapper.selectByExample(example);
        PageBean<Project> pageBean = new PageBean<Project>(projectList);
        pageBean.setPages(page.getPages());
        pageBean.setTotal(page.getTotal());
        pageBean.setCurrPage(page.getPageNum());
        pageBean.setPageSize(page.getPageSize());
        return pageBean;
    }


    /**
     * 分页查询项目，支持的属性请查看getProjectExample()
     * @param project 需要匹配的属性值存储在project对象中
     * @return com.students.utils.Pagination.PageBean<com.students.bean.Project>
     * @author zxy
     * @create 2019/4/14 20:12
     **/
    public PageBean<Project> listProjectsByPage(Project project) {
        ProjectExample example = getProjectExample(project);
        return startSelectByPage(example);
    }

    /**
     * 将项目project转化为projectExample，支持stuId、status。主要是为了防止代码重复
     * @param project 待转化的项目project
     * @return com.students.bean.ProjectExample
     * @author zxy
     * @create 2019/4/23 16:09
     **/
    private ProjectExample getProjectExample(Project project) {
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        if(project.getStuId() != null){
            criteria.andStuIdEqualTo(project.getStuId());
        }
        if(project.getStatus() != null){
            criteria.andStatusEqualTo(project.getStatus());
        }
        return example;
    }

    /**
     * 模糊搜索，支持的字段包括name、startDate、endDate、env、frame、role、roleDetl、duty、stuId、stuName、prizeId、status
     * @param project 支持的字段包括name、startDate、endDate、env、frame、role、roleDetl、duty、stuId、stuName、prizeId、status
     * @return com.students.utils.Pagination.PageBean<com.students.bean.Project>
     * @author zxy
     * @create 2019/4/14 20:42
     **/
    public PageBean<Project> listAlikeProjectsByPage(Project project) {
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        if(Data.isValid(project.getName())){
            criteria.andNameLike("%" + project.getName() + "%");
        }
        if(Data.isValid(project.getStartDate())){
            criteria.andStartDateGreaterThanOrEqualTo(project.getStartDate());
        }
        if(Data.isValid(project.getEndDate())){
            criteria.andEndDateLessThanOrEqualTo(project.getEndDate());
        }
        if(Data.isValid(project.getEnv())){
            criteria.andEnvLike("%" + project.getEnv() + "%");
        }
        if(Data.isValid(project.getFrame())){
            criteria.andFrameLike("%" + project.getFrame() + "%");
        }
        if(Data.isValid(project.getRole())){
            criteria.andRoleLike("%" + project.getRole() + "%");
        }
        if(Data.isValid(project.getRoleDetl())){
            criteria.andRoleDetlLike("%" + project.getRoleDetl() + "%");
        }
        if(Data.isValid(project.getStuName())){
            criteria.andStuNameLike("%" + project.getStuName() + "%");
        }
        if(Data.isValid(project.getDuty())){
            criteria.andDutyLike("%" + project.getDuty() + "%");
        }
        if(Data.isValid(project.getStuId())){
            criteria.andStuIdLike("%" + project.getStuId() + "%");
        }
        if(Data.isValid(project.getPrizeId())){
            criteria.andPrizeIdEqualTo(project.getPrizeId());
        }
        if(Data.isValid(project.getStatus())){
            criteria.andStatusEqualTo(project.getStatus());
        }
        return startSelectByPage(example);
    }

    /**
     * 设置项目project的状态——通过、不通过
     * @param id 项目project的Id
     * @param isPass pass和unPass两种状态
     * @param reason 未通过原因
     * @return boolean
     * @author zxy
     * @create 2019/4/23 15:40
     **/
    public boolean reviewProject(String id, String isPass, String reason){
        Project project = new Project();
        project.setId(id);
        if("pass".equals(isPass)){
            project.setStatus(Data.reviewPass);
        }else if("unpass".equals(isPass)){
            if(reason != null){
                System.out.println("----------------" + reason + "-----------------------------");
                project.setReason(reason);
            }
            project.setStatus(Data.reviewNotPass);
        }
        return projectMapper.updateByPrimaryKeySelective(project) == 1;
     }
}
