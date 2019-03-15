package com.students.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentsorgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentsorgExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
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

        public Criteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgDutyIsNull() {
            addCriterion("ORG_DUTY is null");
            return (Criteria) this;
        }

        public Criteria andOrgDutyIsNotNull() {
            addCriterion("ORG_DUTY is not null");
            return (Criteria) this;
        }

        public Criteria andOrgDutyEqualTo(String value) {
            addCriterion("ORG_DUTY =", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyNotEqualTo(String value) {
            addCriterion("ORG_DUTY <>", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyGreaterThan(String value) {
            addCriterion("ORG_DUTY >", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_DUTY >=", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyLessThan(String value) {
            addCriterion("ORG_DUTY <", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyLessThanOrEqualTo(String value) {
            addCriterion("ORG_DUTY <=", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyLike(String value) {
            addCriterion("ORG_DUTY like", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyNotLike(String value) {
            addCriterion("ORG_DUTY not like", value, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyIn(List<String> values) {
            addCriterion("ORG_DUTY in", values, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyNotIn(List<String> values) {
            addCriterion("ORG_DUTY not in", values, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyBetween(String value1, String value2) {
            addCriterion("ORG_DUTY between", value1, value2, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgDutyNotBetween(String value1, String value2) {
            addCriterion("ORG_DUTY not between", value1, value2, "orgDuty");
            return (Criteria) this;
        }

        public Criteria andOrgBeginIsNull() {
            addCriterion("ORG_BEGIN is null");
            return (Criteria) this;
        }

        public Criteria andOrgBeginIsNotNull() {
            addCriterion("ORG_BEGIN is not null");
            return (Criteria) this;
        }

        public Criteria andOrgBeginEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_BEGIN =", value, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginNotEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_BEGIN <>", value, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginGreaterThan(Date value) {
            addCriterionForJDBCDate("ORG_BEGIN >", value, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_BEGIN >=", value, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginLessThan(Date value) {
            addCriterionForJDBCDate("ORG_BEGIN <", value, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_BEGIN <=", value, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginIn(List<Date> values) {
            addCriterionForJDBCDate("ORG_BEGIN in", values, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginNotIn(List<Date> values) {
            addCriterionForJDBCDate("ORG_BEGIN not in", values, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ORG_BEGIN between", value1, value2, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgBeginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ORG_BEGIN not between", value1, value2, "orgBegin");
            return (Criteria) this;
        }

        public Criteria andOrgEndIsNull() {
            addCriterion("ORG_END is null");
            return (Criteria) this;
        }

        public Criteria andOrgEndIsNotNull() {
            addCriterion("ORG_END is not null");
            return (Criteria) this;
        }

        public Criteria andOrgEndEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_END =", value, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_END <>", value, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndGreaterThan(Date value) {
            addCriterionForJDBCDate("ORG_END >", value, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_END >=", value, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndLessThan(Date value) {
            addCriterionForJDBCDate("ORG_END <", value, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ORG_END <=", value, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndIn(List<Date> values) {
            addCriterionForJDBCDate("ORG_END in", values, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("ORG_END not in", values, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ORG_END between", value1, value2, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ORG_END not between", value1, value2, "orgEnd");
            return (Criteria) this;
        }

        public Criteria andOrgHonorIsNull() {
            addCriterion("ORG_HONOR is null");
            return (Criteria) this;
        }

        public Criteria andOrgHonorIsNotNull() {
            addCriterion("ORG_HONOR is not null");
            return (Criteria) this;
        }

        public Criteria andOrgHonorEqualTo(String value) {
            addCriterion("ORG_HONOR =", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorNotEqualTo(String value) {
            addCriterion("ORG_HONOR <>", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorGreaterThan(String value) {
            addCriterion("ORG_HONOR >", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_HONOR >=", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorLessThan(String value) {
            addCriterion("ORG_HONOR <", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorLessThanOrEqualTo(String value) {
            addCriterion("ORG_HONOR <=", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorLike(String value) {
            addCriterion("ORG_HONOR like", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorNotLike(String value) {
            addCriterion("ORG_HONOR not like", value, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorIn(List<String> values) {
            addCriterion("ORG_HONOR in", values, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorNotIn(List<String> values) {
            addCriterion("ORG_HONOR not in", values, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorBetween(String value1, String value2) {
            addCriterion("ORG_HONOR between", value1, value2, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgHonorNotBetween(String value1, String value2) {
            addCriterion("ORG_HONOR not between", value1, value2, "orgHonor");
            return (Criteria) this;
        }

        public Criteria andOrgClassIsNull() {
            addCriterion("ORG_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andOrgClassIsNotNull() {
            addCriterion("ORG_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andOrgClassEqualTo(String value) {
            addCriterion("ORG_CLASS =", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassNotEqualTo(String value) {
            addCriterion("ORG_CLASS <>", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassGreaterThan(String value) {
            addCriterion("ORG_CLASS >", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_CLASS >=", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassLessThan(String value) {
            addCriterion("ORG_CLASS <", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassLessThanOrEqualTo(String value) {
            addCriterion("ORG_CLASS <=", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassLike(String value) {
            addCriterion("ORG_CLASS like", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassNotLike(String value) {
            addCriterion("ORG_CLASS not like", value, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassIn(List<String> values) {
            addCriterion("ORG_CLASS in", values, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassNotIn(List<String> values) {
            addCriterion("ORG_CLASS not in", values, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassBetween(String value1, String value2) {
            addCriterion("ORG_CLASS between", value1, value2, "orgClass");
            return (Criteria) this;
        }

        public Criteria andOrgClassNotBetween(String value1, String value2) {
            addCriterion("ORG_CLASS not between", value1, value2, "orgClass");
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

        public Criteria andOrgTypeIsNull() {
            addCriterion("ORG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("ORG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("ORG_TYPE =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("ORG_TYPE <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("ORG_TYPE >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("ORG_TYPE <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("ORG_TYPE like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("ORG_TYPE not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("ORG_TYPE in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("ORG_TYPE not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("ORG_TYPE between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("ORG_TYPE not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNull() {
            addCriterion("SUBMIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNotNull() {
            addCriterion("SUBMIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateEqualTo(Date value) {
            addCriterion("SUBMIT_DATE =", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotEqualTo(Date value) {
            addCriterion("SUBMIT_DATE <>", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThan(Date value) {
            addCriterion("SUBMIT_DATE >", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SUBMIT_DATE >=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThan(Date value) {
            addCriterion("SUBMIT_DATE <", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThanOrEqualTo(Date value) {
            addCriterion("SUBMIT_DATE <=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIn(List<Date> values) {
            addCriterion("SUBMIT_DATE in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotIn(List<Date> values) {
            addCriterion("SUBMIT_DATE not in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateBetween(Date value1, Date value2) {
            addCriterion("SUBMIT_DATE between", value1, value2, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotBetween(Date value1, Date value2) {
            addCriterion("SUBMIT_DATE not between", value1, value2, "submitDate");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNull() {
            addCriterion("REVIEWER is null");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNotNull() {
            addCriterion("REVIEWER is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerEqualTo(String value) {
            addCriterion("REVIEWER =", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotEqualTo(String value) {
            addCriterion("REVIEWER <>", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThan(String value) {
            addCriterion("REVIEWER >", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEWER >=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThan(String value) {
            addCriterion("REVIEWER <", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThanOrEqualTo(String value) {
            addCriterion("REVIEWER <=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLike(String value) {
            addCriterion("REVIEWER like", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotLike(String value) {
            addCriterion("REVIEWER not like", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerIn(List<String> values) {
            addCriterion("REVIEWER in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotIn(List<String> values) {
            addCriterion("REVIEWER not in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerBetween(String value1, String value2) {
            addCriterion("REVIEWER between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotBetween(String value1, String value2) {
            addCriterion("REVIEWER not between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewDateIsNull() {
            addCriterion("REVIEW_DATE is null");
            return (Criteria) this;
        }

        public Criteria andReviewDateIsNotNull() {
            addCriterion("REVIEW_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andReviewDateEqualTo(Date value) {
            addCriterion("REVIEW_DATE =", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateNotEqualTo(Date value) {
            addCriterion("REVIEW_DATE <>", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateGreaterThan(Date value) {
            addCriterion("REVIEW_DATE >", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateGreaterThanOrEqualTo(Date value) {
            addCriterion("REVIEW_DATE >=", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateLessThan(Date value) {
            addCriterion("REVIEW_DATE <", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateLessThanOrEqualTo(Date value) {
            addCriterion("REVIEW_DATE <=", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateIn(List<Date> values) {
            addCriterion("REVIEW_DATE in", values, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateNotIn(List<Date> values) {
            addCriterion("REVIEW_DATE not in", values, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateBetween(Date value1, Date value2) {
            addCriterion("REVIEW_DATE between", value1, value2, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateNotBetween(Date value1, Date value2) {
            addCriterion("REVIEW_DATE not between", value1, value2, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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