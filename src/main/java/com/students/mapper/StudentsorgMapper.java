package com.students.mapper;

import com.students.bean.Studentsorg;
import com.students.bean.StudentsorgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsorgMapper {
    int countByExample(StudentsorgExample example);

    int deleteByExample(StudentsorgExample example);

    int deleteByPrimaryKey(Integer orgId);

    int insert(Studentsorg record);

    int insertSelective(Studentsorg record);

    List<Studentsorg> selectByExampleWithBLOBs(StudentsorgExample example);

    List<Studentsorg> selectByExample(StudentsorgExample example);

    Studentsorg selectByPrimaryKey(Integer orgId);

    int updateByExampleSelective(@Param("record") Studentsorg record, @Param("example") StudentsorgExample example);

    int updateByExampleWithBLOBs(@Param("record") Studentsorg record, @Param("example") StudentsorgExample example);

    int updateByExample(@Param("record") Studentsorg record, @Param("example") StudentsorgExample example);

    int updateByPrimaryKeySelective(Studentsorg record);

    int updateByPrimaryKeyWithBLOBs(Studentsorg record);

    int updateByPrimaryKey(Studentsorg record);
}