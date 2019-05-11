package com.students.bean;

import java.util.Date;

/**
 * @author zxy
 * @project rcglk
 * @description project表单，用于搜索学生项目project
 * @email zxy@nmzl.cc
 * @date 2019-04-17-10:32
 **/
public class SearchProject extends Project{
    private Date submitDateStart;

    private Date submitDateEnd;

    private Date reviewDateStart;

    private Date reviewDateEnd;

    public Date getSubmitDateStart() {
        return submitDateStart;
    }

    public void setSubmitDateStart(Date submitDateStart) {
        this.submitDateStart = submitDateStart;
    }

    public Date getSubmitDateEnd() {
        return submitDateEnd;
    }

    public void setSubmitDateEnd(Date submitDateEnd) {
        this.submitDateEnd = submitDateEnd;
    }

    public Date getReviewDateStart() {
        return reviewDateStart;
    }

    public void setReviewDateStart(Date reviewDateStart) {
        this.reviewDateStart = reviewDateStart;
    }

    public Date getReviewDateEnd() {
        return reviewDateEnd;
    }

    public void setReviewDateEnd(Date reviewDateEnd) {
        this.reviewDateEnd = reviewDateEnd;
    }
}
