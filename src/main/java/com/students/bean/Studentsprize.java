package com.students.bean;

import java.util.Date;

public class Studentsprize {
    private Integer prizeId;

    private String stuId;

    private String stuName;

    private String prizeName;

    private Date prizeDate;

    private String prizeClass;

    private String prizeLevel;

    private String prizeLevel2;

    private String prizeFile;

    private String status;

    private Date submitDate;

    private String reason;

    private Date checkTime;

    private String prizeIntro;

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
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

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public Date getPrizeDate() {
        return prizeDate;
    }

    public void setPrizeDate(Date prizeDate) {
        this.prizeDate = prizeDate;
    }

    public String getPrizeClass() {
        return prizeClass;
    }

    public void setPrizeClass(String prizeClass) {
        this.prizeClass = prizeClass == null ? null : prizeClass.trim();
    }

    public String getPrizeLevel() {
        return prizeLevel;
    }

    public void setPrizeLevel(String prizeLevel) {
        this.prizeLevel = prizeLevel == null ? null : prizeLevel.trim();
    }

    public String getPrizeLevel2() {
        return prizeLevel2;
    }

    public void setPrizeLevel2(String prizeLevel2) {
        this.prizeLevel2 = prizeLevel2 == null ? null : prizeLevel2.trim();
    }

    public String getPrizeFile() {
        return prizeFile;
    }

    public void setPrizeFile(String prizeFile) {
        this.prizeFile = prizeFile == null ? null : prizeFile.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getPrizeIntro() {
        return prizeIntro;
    }

    public void setPrizeIntro(String prizeIntro) {
        this.prizeIntro = prizeIntro == null ? null : prizeIntro.trim();
    }
}