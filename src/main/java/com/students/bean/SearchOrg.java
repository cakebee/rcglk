package com.students.bean;

import java.util.Date;

public class SearchOrg extends Studentsorg {
    private Date submitDateBegin;

    private Date submitDateEnd;

    private Date reviewDateBegin;

    private Date reviewDateEnd;

    public Date getSubmitDateBegin() {
        return submitDateBegin;
    }

    public void setSubmitDateBegin(Date submitDateBegin) {
        this.submitDateBegin = submitDateBegin;
    }

    public Date getSubmitDateEnd() {
        return submitDateEnd;
    }

    public void setSubmitDateEnd(Date submitDateEnd) {
        this.submitDateEnd = submitDateEnd;
    }

    public Date getReviewDateBegin() {
        return reviewDateBegin;
    }

    public void setReviewDateBegin(Date reviewDateBegin) {
        this.reviewDateBegin = reviewDateBegin;
    }

    public Date getReviewDateEnd() {
        return reviewDateEnd;
    }

    public void setReviewDateEnd(Date reviewDateEnd) {
        this.reviewDateEnd = reviewDateEnd;
    }
}
