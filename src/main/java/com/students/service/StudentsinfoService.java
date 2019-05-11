package com.students.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.Studentsinfo;
import com.students.bean.StudentsinfoExample;
import com.students.mapper.StudentsinfoMapper;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.bean.Studentspass;
import com.students.bean.StudentspassExample;
import com.students.mapper.StudentspassMapper;

@Service
public class StudentsinfoService {

    @Autowired
    private StudentsinfoMapper studentsinfoMapper;

    @Autowired
    private StudentspassMapper studentspassMapper;


    public void deleteStuInfo(String id) {
        studentsinfoMapper.deleteByPrimaryKey(id);

    }

    public List<Studentsinfo> getOne(String stuId) {
        StudentsinfoExample example = new StudentsinfoExample();
        StudentsinfoExample.Criteria cri = example.createCriteria();
        cri.andStuIdLike(stuId);

        return studentsinfoMapper.selectByExample(example);

    }

    public List<Studentsinfo> getAll() {
        return studentsinfoMapper.selectByExample(null);

    }

    //分页查询
    public PageBean<Studentsinfo> getByPage() {
        Page<Studentsinfo> page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        List<Studentsinfo> studentsinfoList = studentsinfoMapper.selectByExample(null);
        PageBean<Studentsinfo> studentsinfoPageBean = new PageBean<Studentsinfo>(studentsinfoList);
        studentsinfoPageBean.setTotal(page.getTotal());
        studentsinfoPageBean.setCurrPage(page.getPageNum());
        studentsinfoPageBean.setPages(page.getPages());
        studentsinfoPageBean.setPageSize(page.getPageSize());
        return studentsinfoPageBean;
    }

    public PageBean<Studentsinfo> searchByPage(Studentsinfo studentsinfo) {
        PageBean<Studentsinfo> studentsinfoPageBean;
        Page<Studentsinfo> page;
        List<Studentsinfo> studentsinfoList;
        StudentsinfoExample example = new StudentsinfoExample();
        StudentsinfoExample.Criteria criteria = example.createCriteria();
        if(studentsinfo.getStuId() != null && !studentsinfo.getStuId().equals("")){
            criteria.andStuIdLike("%"+studentsinfo.getStuId()+"%");
        }
        if(studentsinfo.getIdentity() != null && !studentsinfo.getIdentity().equals("")){
            criteria.andIdentityLike("%"+studentsinfo.getIdentity()+"%");
        }
        if(studentsinfo.getStuAge() != null && !studentsinfo.getStuAge().equals("")){
            criteria.andStuAgeBetween(studentsinfo.getStuAge()-1, studentsinfo.getStuAge()+1);
        }
        if(studentsinfo.getStuName() != null && !studentsinfo.getStuName().equals("")){
            criteria.andStuNameLike("%"+studentsinfo.getStuName()+"%");
        }
        if(studentsinfo.getStuGender() != null && !studentsinfo.getStuGender().equals("")){
            System.out.println(studentsinfo.getStuGender().length());
            criteria.andStuGenderLike("%" + studentsinfo.getStuGender() + "%");
        }
        if(studentsinfo.getStuMajor() != null && !studentsinfo.getStuMajor().equals("")){
            criteria.andStuMajorLike("%"+studentsinfo.getStuMajor()+"%");
        }
        if(studentsinfo.getClass() != null && !studentsinfo.getStuClass().equals("")){
            criteria.andStuClassLike("%"+studentsinfo.getStuClass()+"%");
        }
        if(studentsinfo.getStuStatus() != null && !studentsinfo.getStuStatus().equals("")){
            criteria.andStuStatusEqualTo("%"+studentsinfo.getStuStatus()+"%");
        }
        if(studentsinfo.getStuDorm() != null && !studentsinfo.getStuDorm().equals("")){
            criteria.andStuDormLike("%"+studentsinfo.getStuDorm()+"%");
        }
        if(studentsinfo.getStuTel() != null && !studentsinfo.getStuTel().equals("")){
            criteria.andStuTelLike("%"+studentsinfo.getStuTel()+"%");
        }
        if(studentsinfo.getStuQq() != null && !studentsinfo.getStuQq().equals("")){
            criteria.andStuQqLike("%"+studentsinfo.getStuQq()+"%");
        }
        if(studentsinfo.getStuGpa() != null && !studentsinfo.getStuGpa().equals("")){
            criteria.andStuGpaLike("%"+studentsinfo.getStuGpa()+"%");
        }

        page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        studentsinfoList = studentsinfoMapper.selectByExample(example);
        studentsinfoPageBean = new PageBean<Studentsinfo>(studentsinfoList);

        studentsinfoPageBean.setPages(page.getPages());
        studentsinfoPageBean.setTotal(page.getTotal());
        studentsinfoPageBean.setCurrPage(page.getPageNum());
        studentsinfoPageBean.setPageSize(page.getPageSize());

        return studentsinfoPageBean;
    }

    public void updateStudentsinfo(Studentsinfo studentsinfo) {
        studentsinfoMapper.updateByPrimaryKeySelective(studentsinfo);
        //studentsinfoMapper.updateByPrimaryKey(studentsinfo);

    }

    /**
     * shen新增学生，写入学生密码库 默认密码为学号
     *
     * @param stuId
     */
    public boolean addStudentsinfo(String stuId) {
        //先查询该学生是否被创建
        StudentspassExample example = new StudentspassExample();
        com.students.bean.StudentspassExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        int i = studentspassMapper.countByExample(example);
        if (i == 0) {


            Studentspass record = new Studentspass();
            record.setStuId(stuId);
            record.setStuPsw(stuId);
            studentspassMapper.insert(record);
            return true;
        }
        return false;
    }

    /**
     * 查询学生用户是否被注册
     *
     * @param stuId
     * @param password
     * @return
     */

    public boolean isStudent(String stuId, String password) {
        Studentspass studentPass = studentspassMapper.selectByPrimaryKey(stuId);
        if (studentPass != null) {
            if (studentPass.getStuPsw().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean insert(Studentsinfo studentsinfo) {
        int i = studentsinfoMapper.insertSelective(studentsinfo);
        if (i == 0) {
            return false;
        }
        return true;
    }

}
