package com.students.bean;

public class Studentsinfo {
    private String stuId;

    private String stuName;

    private String stuGender;

    private Integer stuAge;

    private String identity;

    private String stuClass;

    private String stuMajor;

    private String stuDorm;

    private String stuQq;

    private String stuTel;

    private String stuStatus;

    private String stuHome;

    private String stuIntro;

    private String stuGrade;

    private String stuGpa;

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

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender == null ? null : stuGender.trim();
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass == null ? null : stuClass.trim();
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor == null ? null : stuMajor.trim();
    }

    public String getStuDorm() {
        return stuDorm;
    }

    public void setStuDorm(String stuDorm) {
        this.stuDorm = stuDorm == null ? null : stuDorm.trim();
    }

    public String getStuQq() {
        return stuQq;
    }

    public void setStuQq(String stuQq) {
        this.stuQq = stuQq == null ? null : stuQq.trim();
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel == null ? null : stuTel.trim();
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus == null ? null : stuStatus.trim();
    }

    public String getStuHome() {
        return stuHome;
    }

    public void setStuHome(String stuHome) {
        this.stuHome = stuHome == null ? null : stuHome.trim();
    }

    public String getStuIntro() {
        return stuIntro;
    }

    public void setStuIntro(String stuIntro) {
        this.stuIntro = stuIntro == null ? null : stuIntro.trim();
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade == null ? null : stuGrade.trim();
    }

    public String getStuGpa() {
        return stuGpa;
    }

    public void setStuGpa(String stuGpa) {
        this.stuGpa = stuGpa == null ? null : stuGpa.trim();
    }
}