package com.students.mapper;

import com.students.bean.Studentsquality;
import com.students.bean.StudentsqualityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsqualityMapper {
    int countByExample(StudentsqualityExample example);

    int deleteByExample(StudentsqualityExample example);

    int deleteByPrimaryKey(String stuId);

    int insert(Studentsquality record);

    int replaceInto(List<Studentsquality> list);

    int insertSelective(Studentsquality record);

    List<Studentsquality> selectByExample(StudentsqualityExample example);

    Studentsquality selectByPrimaryKey(String stuId);

    int updateByExampleSelective(@Param("record") Studentsquality record, @Param("example") StudentsqualityExample example);

    int updateByExample(@Param("record") Studentsquality record, @Param("example") StudentsqualityExample example);

    int updateByPrimaryKeySelective(Studentsquality record);

    int updateByPrimaryKey(Studentsquality record);
}
