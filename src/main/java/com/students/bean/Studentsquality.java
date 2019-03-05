package com.students.bean;

public class Studentsquality {
    private String stuId;

    private Integer qScientific;

    private Integer qGrade;

    private Integer qOrg;

    private Integer quality;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getqScientific() {
        return qScientific;
    }

    public void setqScientific(Integer qScientific) {
        this.qScientific = qScientific;
    }

    public Integer getqGrade() {
        return qGrade;
    }

    public void setqGrade(Integer qGrade) {
        this.qGrade = qGrade;
    }

    public Integer getqOrg() {
        return qOrg;
    }

    public void setqOrg(Integer qOrg) {
        this.qOrg = qOrg;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }
}