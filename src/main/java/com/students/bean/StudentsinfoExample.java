package com.students.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentsinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentsinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStuIdIsNull() {
            addCriterion("STU_ID is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("STU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("STU_ID =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("STU_ID <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("STU_ID >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("STU_ID >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("STU_ID <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("STU_ID <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("STU_ID like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("STU_ID not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("STU_ID in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("STU_ID not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("STU_ID between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("STU_ID not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("STU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("STU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("STU_NAME =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("STU_NAME <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("STU_NAME >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("STU_NAME >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("STU_NAME <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("STU_NAME <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("STU_NAME like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("STU_NAME not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("STU_NAME in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("STU_NAME not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("STU_NAME between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("STU_NAME not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNull() {
            addCriterion("STU_GENDER is null");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNotNull() {
            addCriterion("STU_GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andStuGenderEqualTo(String value) {
            addCriterion("STU_GENDER =", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotEqualTo(String value) {
            addCriterion("STU_GENDER <>", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThan(String value) {
            addCriterion("STU_GENDER >", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThanOrEqualTo(String value) {
            addCriterion("STU_GENDER >=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThan(String value) {
            addCriterion("STU_GENDER <", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThanOrEqualTo(String value) {
            addCriterion("STU_GENDER <=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLike(String value) {
            addCriterion("STU_GENDER like", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotLike(String value) {
            addCriterion("STU_GENDER not like", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderIn(List<String> values) {
            addCriterion("STU_GENDER in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotIn(List<String> values) {
            addCriterion("STU_GENDER not in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderBetween(String value1, String value2) {
            addCriterion("STU_GENDER between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotBetween(String value1, String value2) {
            addCriterion("STU_GENDER not between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuAgeIsNull() {
            addCriterion("STU_AGE is null");
            return (Criteria) this;
        }

        public Criteria andStuAgeIsNotNull() {
            addCriterion("STU_AGE is not null");
            return (Criteria) this;
        }

        public Criteria andStuAgeEqualTo(Integer value) {
            addCriterion("STU_AGE =", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotEqualTo(Integer value) {
            addCriterion("STU_AGE <>", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeGreaterThan(Integer value) {
            addCriterion("STU_AGE >", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("STU_AGE >=", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeLessThan(Integer value) {
            addCriterion("STU_AGE <", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeLessThanOrEqualTo(Integer value) {
            addCriterion("STU_AGE <=", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeIn(List<Integer> values) {
            addCriterion("STU_AGE in", values, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotIn(List<Integer> values) {
            addCriterion("STU_AGE not in", values, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeBetween(Integer value1, Integer value2) {
            addCriterion("STU_AGE between", value1, value2, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("STU_AGE not between", value1, value2, "stuAge");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("IDENTITY is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("IDENTITY is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("IDENTITY =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("IDENTITY <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("IDENTITY >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTITY >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("IDENTITY <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("IDENTITY <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("IDENTITY like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("IDENTITY not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("IDENTITY in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("IDENTITY not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("IDENTITY between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("IDENTITY not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andStuClassIsNull() {
            addCriterion("STU_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andStuClassIsNotNull() {
            addCriterion("STU_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andStuClassEqualTo(String value) {
            addCriterion("STU_CLASS =", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotEqualTo(String value) {
            addCriterion("STU_CLASS <>", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassGreaterThan(String value) {
            addCriterion("STU_CLASS >", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassGreaterThanOrEqualTo(String value) {
            addCriterion("STU_CLASS >=", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLessThan(String value) {
            addCriterion("STU_CLASS <", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLessThanOrEqualTo(String value) {
            addCriterion("STU_CLASS <=", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLike(String value) {
            addCriterion("STU_CLASS like", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotLike(String value) {
            addCriterion("STU_CLASS not like", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassIn(List<String> values) {
            addCriterion("STU_CLASS in", values, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotIn(List<String> values) {
            addCriterion("STU_CLASS not in", values, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassBetween(String value1, String value2) {
            addCriterion("STU_CLASS between", value1, value2, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotBetween(String value1, String value2) {
            addCriterion("STU_CLASS not between", value1, value2, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNull() {
            addCriterion("STU_MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNotNull() {
            addCriterion("STU_MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andStuMajorEqualTo(String value) {
            addCriterion("STU_MAJOR =", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotEqualTo(String value) {
            addCriterion("STU_MAJOR <>", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThan(String value) {
            addCriterion("STU_MAJOR >", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThanOrEqualTo(String value) {
            addCriterion("STU_MAJOR >=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThan(String value) {
            addCriterion("STU_MAJOR <", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThanOrEqualTo(String value) {
            addCriterion("STU_MAJOR <=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLike(String value) {
            addCriterion("STU_MAJOR like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotLike(String value) {
            addCriterion("STU_MAJOR not like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorIn(List<String> values) {
            addCriterion("STU_MAJOR in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotIn(List<String> values) {
            addCriterion("STU_MAJOR not in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorBetween(String value1, String value2) {
            addCriterion("STU_MAJOR between", value1, value2, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotBetween(String value1, String value2) {
            addCriterion("STU_MAJOR not between", value1, value2, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuDormIsNull() {
            addCriterion("STU_DORM is null");
            return (Criteria) this;
        }

        public Criteria andStuDormIsNotNull() {
            addCriterion("STU_DORM is not null");
            return (Criteria) this;
        }

        public Criteria andStuDormEqualTo(String value) {
            addCriterion("STU_DORM =", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormNotEqualTo(String value) {
            addCriterion("STU_DORM <>", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormGreaterThan(String value) {
            addCriterion("STU_DORM >", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormGreaterThanOrEqualTo(String value) {
            addCriterion("STU_DORM >=", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormLessThan(String value) {
            addCriterion("STU_DORM <", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormLessThanOrEqualTo(String value) {
            addCriterion("STU_DORM <=", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormLike(String value) {
            addCriterion("STU_DORM like", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormNotLike(String value) {
            addCriterion("STU_DORM not like", value, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormIn(List<String> values) {
            addCriterion("STU_DORM in", values, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormNotIn(List<String> values) {
            addCriterion("STU_DORM not in", values, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormBetween(String value1, String value2) {
            addCriterion("STU_DORM between", value1, value2, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuDormNotBetween(String value1, String value2) {
            addCriterion("STU_DORM not between", value1, value2, "stuDorm");
            return (Criteria) this;
        }

        public Criteria andStuQqIsNull() {
            addCriterion("STU_QQ is null");
            return (Criteria) this;
        }

        public Criteria andStuQqIsNotNull() {
            addCriterion("STU_QQ is not null");
            return (Criteria) this;
        }

        public Criteria andStuQqEqualTo(String value) {
            addCriterion("STU_QQ =", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotEqualTo(String value) {
            addCriterion("STU_QQ <>", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqGreaterThan(String value) {
            addCriterion("STU_QQ >", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqGreaterThanOrEqualTo(String value) {
            addCriterion("STU_QQ >=", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqLessThan(String value) {
            addCriterion("STU_QQ <", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqLessThanOrEqualTo(String value) {
            addCriterion("STU_QQ <=", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqLike(String value) {
            addCriterion("STU_QQ like", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotLike(String value) {
            addCriterion("STU_QQ not like", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqIn(List<String> values) {
            addCriterion("STU_QQ in", values, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotIn(List<String> values) {
            addCriterion("STU_QQ not in", values, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqBetween(String value1, String value2) {
            addCriterion("STU_QQ between", value1, value2, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotBetween(String value1, String value2) {
            addCriterion("STU_QQ not between", value1, value2, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuTelIsNull() {
            addCriterion("STU_TEL is null");
            return (Criteria) this;
        }

        public Criteria andStuTelIsNotNull() {
            addCriterion("STU_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andStuTelEqualTo(String value) {
            addCriterion("STU_TEL =", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelNotEqualTo(String value) {
            addCriterion("STU_TEL <>", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelGreaterThan(String value) {
            addCriterion("STU_TEL >", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelGreaterThanOrEqualTo(String value) {
            addCriterion("STU_TEL >=", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelLessThan(String value) {
            addCriterion("STU_TEL <", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelLessThanOrEqualTo(String value) {
            addCriterion("STU_TEL <=", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelLike(String value) {
            addCriterion("STU_TEL like", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelNotLike(String value) {
            addCriterion("STU_TEL not like", value, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelIn(List<String> values) {
            addCriterion("STU_TEL in", values, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelNotIn(List<String> values) {
            addCriterion("STU_TEL not in", values, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelBetween(String value1, String value2) {
            addCriterion("STU_TEL between", value1, value2, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuTelNotBetween(String value1, String value2) {
            addCriterion("STU_TEL not between", value1, value2, "stuTel");
            return (Criteria) this;
        }

        public Criteria andStuStatusIsNull() {
            addCriterion("STU_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStuStatusIsNotNull() {
            addCriterion("STU_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStuStatusEqualTo(String value) {
            addCriterion("STU_STATUS =", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotEqualTo(String value) {
            addCriterion("STU_STATUS <>", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusGreaterThan(String value) {
            addCriterion("STU_STATUS >", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STU_STATUS >=", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLessThan(String value) {
            addCriterion("STU_STATUS <", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLessThanOrEqualTo(String value) {
            addCriterion("STU_STATUS <=", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLike(String value) {
            addCriterion("STU_STATUS like", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotLike(String value) {
            addCriterion("STU_STATUS not like", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusIn(List<String> values) {
            addCriterion("STU_STATUS in", values, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotIn(List<String> values) {
            addCriterion("STU_STATUS not in", values, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusBetween(String value1, String value2) {
            addCriterion("STU_STATUS between", value1, value2, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotBetween(String value1, String value2) {
            addCriterion("STU_STATUS not between", value1, value2, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuHomeIsNull() {
            addCriterion("STU_HOME is null");
            return (Criteria) this;
        }

        public Criteria andStuHomeIsNotNull() {
            addCriterion("STU_HOME is not null");
            return (Criteria) this;
        }

        public Criteria andStuHomeEqualTo(String value) {
            addCriterion("STU_HOME =", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeNotEqualTo(String value) {
            addCriterion("STU_HOME <>", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeGreaterThan(String value) {
            addCriterion("STU_HOME >", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeGreaterThanOrEqualTo(String value) {
            addCriterion("STU_HOME >=", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeLessThan(String value) {
            addCriterion("STU_HOME <", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeLessThanOrEqualTo(String value) {
            addCriterion("STU_HOME <=", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeLike(String value) {
            addCriterion("STU_HOME like", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeNotLike(String value) {
            addCriterion("STU_HOME not like", value, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeIn(List<String> values) {
            addCriterion("STU_HOME in", values, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeNotIn(List<String> values) {
            addCriterion("STU_HOME not in", values, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeBetween(String value1, String value2) {
            addCriterion("STU_HOME between", value1, value2, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuHomeNotBetween(String value1, String value2) {
            addCriterion("STU_HOME not between", value1, value2, "stuHome");
            return (Criteria) this;
        }

        public Criteria andStuIntroIsNull() {
            addCriterion("STU_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andStuIntroIsNotNull() {
            addCriterion("STU_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andStuIntroEqualTo(String value) {
            addCriterion("STU_INTRO =", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroNotEqualTo(String value) {
            addCriterion("STU_INTRO <>", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroGreaterThan(String value) {
            addCriterion("STU_INTRO >", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroGreaterThanOrEqualTo(String value) {
            addCriterion("STU_INTRO >=", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroLessThan(String value) {
            addCriterion("STU_INTRO <", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroLessThanOrEqualTo(String value) {
            addCriterion("STU_INTRO <=", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroLike(String value) {
            addCriterion("STU_INTRO like", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroNotLike(String value) {
            addCriterion("STU_INTRO not like", value, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroIn(List<String> values) {
            addCriterion("STU_INTRO in", values, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroNotIn(List<String> values) {
            addCriterion("STU_INTRO not in", values, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroBetween(String value1, String value2) {
            addCriterion("STU_INTRO between", value1, value2, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuIntroNotBetween(String value1, String value2) {
            addCriterion("STU_INTRO not between", value1, value2, "stuIntro");
            return (Criteria) this;
        }

        public Criteria andStuGradeIsNull() {
            addCriterion("STU_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andStuGradeIsNotNull() {
            addCriterion("STU_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andStuGradeEqualTo(String value) {
            addCriterion("STU_GRADE =", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotEqualTo(String value) {
            addCriterion("STU_GRADE <>", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeGreaterThan(String value) {
            addCriterion("STU_GRADE >", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeGreaterThanOrEqualTo(String value) {
            addCriterion("STU_GRADE >=", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLessThan(String value) {
            addCriterion("STU_GRADE <", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLessThanOrEqualTo(String value) {
            addCriterion("STU_GRADE <=", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLike(String value) {
            addCriterion("STU_GRADE like", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotLike(String value) {
            addCriterion("STU_GRADE not like", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeIn(List<String> values) {
            addCriterion("STU_GRADE in", values, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotIn(List<String> values) {
            addCriterion("STU_GRADE not in", values, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeBetween(String value1, String value2) {
            addCriterion("STU_GRADE between", value1, value2, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotBetween(String value1, String value2) {
            addCriterion("STU_GRADE not between", value1, value2, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGpaIsNull() {
            addCriterion("STU_GPA is null");
            return (Criteria) this;
        }

        public Criteria andStuGpaIsNotNull() {
            addCriterion("STU_GPA is not null");
            return (Criteria) this;
        }

        public Criteria andStuGpaEqualTo(String value) {
            addCriterion("STU_GPA =", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaNotEqualTo(String value) {
            addCriterion("STU_GPA <>", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaGreaterThan(String value) {
            addCriterion("STU_GPA >", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaGreaterThanOrEqualTo(String value) {
            addCriterion("STU_GPA >=", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaLessThan(String value) {
            addCriterion("STU_GPA <", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaLessThanOrEqualTo(String value) {
            addCriterion("STU_GPA <=", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaLike(String value) {
            addCriterion("STU_GPA like", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaNotLike(String value) {
            addCriterion("STU_GPA not like", value, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaIn(List<String> values) {
            addCriterion("STU_GPA in", values, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaNotIn(List<String> values) {
            addCriterion("STU_GPA not in", values, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaBetween(String value1, String value2) {
            addCriterion("STU_GPA between", value1, value2, "stuGpa");
            return (Criteria) this;
        }

        public Criteria andStuGpaNotBetween(String value1, String value2) {
            addCriterion("STU_GPA not between", value1, value2, "stuGpa");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}