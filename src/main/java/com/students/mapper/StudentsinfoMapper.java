package com.students.mapper;

import com.students.bean.Studentsinfo;
import com.students.bean.StudentsinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsinfoMapper {
    int countByExample(StudentsinfoExample example);

    int deleteByExample(StudentsinfoExample example);

    int deleteByPrimaryKey(String stuId);

    int insert(Studentsinfo record);

    int insertSelective(Studentsinfo record);

    List<Studentsinfo> selectByExample(StudentsinfoExample example);

    Studentsinfo selectByPrimaryKey(String stuId);

    int updateByExampleSelective(@Param("record") Studentsinfo record, @Param("example") StudentsinfoExample example);

    int updateByExample(@Param("record") Studentsinfo record, @Param("example") StudentsinfoExample example);

    int updateByPrimaryKeySelective(Studentsinfo record);

    int updateByPrimaryKey(Studentsinfo record);
}