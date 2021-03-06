package com.students.mapper;

import com.students.bean.Resume;
import com.students.bean.ResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int countByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int deleteByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int deleteByPrimaryKey(String stuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int insert(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int insertSelective(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    List<Resume> selectByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    Resume selectByPrimaryKey(String stuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int updateByExampleSelective(@Param("record") Resume record, @Param("example") ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int updateByPrimaryKeySelective(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Sat Nov 24 15:04:35 CST 2018
     */
    int updateByPrimaryKey(Resume record);
}