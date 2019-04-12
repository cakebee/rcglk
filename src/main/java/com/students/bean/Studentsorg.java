package com.students.bean;

import java.util.Date;

public class Studentsorg {
    private Integer orgId;

    private String stuId;

    private String orgName;

    private String orgDuty;

    private Date orgBegin;

    private Date orgEnd;

    private String orgHonor;

    private String orgIntro;

    private String orgClass;

    private String stuName;

    private String orgType;

    private Date submitDate;

    private String reviewer;

    private Date reviewDate;

    private String reason;

    private Integer status;

    private String file;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgDuty() {
        return orgDuty;
    }

    public void setOrgDuty(String orgDuty) {
        this.orgDuty = orgDuty == null ? null : orgDuty.trim();
    }

    public Date getOrgBegin() {
        return orgBegin;
    }

    public void setOrgBegin(Date orgBegin) {
        this.orgBegin = orgBegin;
    }

    public Date getOrgEnd() {
        return orgEnd;
    }

    public void setOrgEnd(Date orgEnd) {
        this.orgEnd = orgEnd;
    }

    public String getOrgHonor() {
        return orgHonor;
    }

    public void setOrgHonor(String orgHonor) {
        this.orgHonor = orgHonor == null ? null : orgHonor.trim();
    }

    public String getOrgIntro() {
        return orgIntro;
    }

    public void setOrgIntro(String orgIntro) {
        this.orgIntro = orgIntro == null ? null : orgIntro.trim();
    }

    public String getOrgClass() {
        return orgClass;
    }

    public void setOrgClass(String orgClass) {
        this.orgClass = orgClass == null ? null : orgClass.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }
}