package com.students.mapper;

import com.students.bean.Studentsprize;
import com.students.bean.StudentsprizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsprizeMapper {
    int countByExample(StudentsprizeExample example);

    int deleteByExample(StudentsprizeExample example);

    int deleteByPrimaryKey(Integer prizeId);

    int insert(Studentsprize record);

    int insertSelective(Studentsprize record);

    List<Studentsprize> selectByExample(StudentsprizeExample example);

    Studentsprize selectByPrimaryKey(Integer prizeId);

    int updateByExampleSelective(@Param("record") Studentsprize record, @Param("example") StudentsprizeExample example);

    int updateByExample(@Param("record") Studentsprize record, @Param("example") StudentsprizeExample example);

    int updateByPrimaryKeySelective(Studentsprize record);

    int updateByPrimaryKey(Studentsprize record);
}