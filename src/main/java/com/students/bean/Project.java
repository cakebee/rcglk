package com.students.bean;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;

public class Project {
    private String id;

    @NotBlank(message = "项目名不能为空")
    @Size(max = 45, message = "项目名不能超过45个字")
    private String name;

    @NotNull(message = "开始日期不能为空")
    @Past(message = "开始日期不能超过今天")
    private Date startDate;

    @NotNull(message = "结束日期不能为空")
    @Past(message = "结束日期不能超过今天")
    private Date endDate;

    @NotBlank(message = "项目介绍不能为空")
    @Size(max = 500, message = "项目介绍不能超过500字")
    private String intro;

    @Size(max = 100, message = "开发环境不能超过100字")
    private String env;

    @Size(max = 100, message = "框架不能超过100字")
    private String frame;

    @Size(max = 45, message = "担任角色不能超过45字")
    private String role;

    @NotNull(message = "担任角色详情不能为空")
    @Size(max = 45, message = "担任角色详情不能超过45字")
    private String roleDetl;

    @NotNull(message = "职责不能为空")
    @Size(max = 1000,message = "职责不能超过1000字")
    private String duty;

    @NotNull(message = "学号不能为空")
    @Size(max = 13, message = "学号长度不能超过13个数字")
    private String stuId;

    @NotNull(message = "姓名不能为空")
    @Size(max = 45, message = "姓名长度不能超过45")
    private String stuName;

    @Size(max = 500, message = "补充说明不能超过500字")
    private String supp;

    @Size(max = 100, message = "项目链接长度不能超过100字")
    private String projLink;

    @Size(max = 100, message = "源码链接长度不能超过100字")
    private String srcLink;

    private Integer prizeId;

    @Range(min = 0, max = 2, message = "状态码不合法")
    private Integer status;

    private Date submitDate;

    private Date reviewDate;

    @Size(max = 45, message = "审核者不能超过45字")
    private String reviewer;

    @Size(max = 500, message = "理由不能超过500字")
    private String reason;

    @Size(max = 45, message = "文件名长度不超过45")
    private String file;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env == null ? null : env.trim();
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame == null ? null : frame.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getRoleDetl() {
        return roleDetl;
    }

    public void setRoleDetl(String roleDetl) {
        this.roleDetl = roleDetl == null ? null : roleDetl.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getSupp() {
        return supp;
    }

    public void setSupp(String supp) {
        this.supp = supp == null ? null : supp.trim();
    }

    public String getProjLink() {
        return projLink;
    }

    public void setProjLink(String projLink) {
        this.projLink = projLink == null ? null : projLink.trim();
    }

    public String getSrcLink() {
        return srcLink;
    }

    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink == null ? null : srcLink.trim();
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }
}
