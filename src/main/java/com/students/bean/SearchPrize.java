package com.students.bean;

import java.util.Date;

public class SearchPrize extends Studentsprize{
    private Date prizeDateBegin;

    private Date prizeDateEnd;

    private Date submitDateBegin;

    private Date submitDateEnd;

    private Date reviewDateBegin;

    private Date reviewDateEnd;

    public Date getPrizeDateBegin() {
        return prizeDateBegin;
    }

    public void setPrizeDateBegin(Date prizeDateBegin) {
        this.prizeDateBegin = prizeDateBegin;
    }

    public Date getPrizeDateEnd() {
        return prizeDateEnd;
    }

    public void setPrizeDateEnd(Date prizeDateEnd) {
        this.prizeDateEnd = prizeDateEnd;
    }

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
