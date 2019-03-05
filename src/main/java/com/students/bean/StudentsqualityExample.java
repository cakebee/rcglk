package com.students.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentsqualityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentsqualityExample() {
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
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("stu_id like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("stu_id not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andQScientificIsNull() {
            addCriterion("q_scientific is null");
            return (Criteria) this;
        }

        public Criteria andQScientificIsNotNull() {
            addCriterion("q_scientific is not null");
            return (Criteria) this;
        }

        public Criteria andQScientificEqualTo(Integer value) {
            addCriterion("q_scientific =", value, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificNotEqualTo(Integer value) {
            addCriterion("q_scientific <>", value, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificGreaterThan(Integer value) {
            addCriterion("q_scientific >", value, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_scientific >=", value, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificLessThan(Integer value) {
            addCriterion("q_scientific <", value, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificLessThanOrEqualTo(Integer value) {
            addCriterion("q_scientific <=", value, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificIn(List<Integer> values) {
            addCriterion("q_scientific in", values, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificNotIn(List<Integer> values) {
            addCriterion("q_scientific not in", values, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificBetween(Integer value1, Integer value2) {
            addCriterion("q_scientific between", value1, value2, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQScientificNotBetween(Integer value1, Integer value2) {
            addCriterion("q_scientific not between", value1, value2, "qScientific");
            return (Criteria) this;
        }

        public Criteria andQGradeIsNull() {
            addCriterion("q_grade is null");
            return (Criteria) this;
        }

        public Criteria andQGradeIsNotNull() {
            addCriterion("q_grade is not null");
            return (Criteria) this;
        }

        public Criteria andQGradeEqualTo(Integer value) {
            addCriterion("q_grade =", value, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeNotEqualTo(Integer value) {
            addCriterion("q_grade <>", value, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeGreaterThan(Integer value) {
            addCriterion("q_grade >", value, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_grade >=", value, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeLessThan(Integer value) {
            addCriterion("q_grade <", value, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeLessThanOrEqualTo(Integer value) {
            addCriterion("q_grade <=", value, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeIn(List<Integer> values) {
            addCriterion("q_grade in", values, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeNotIn(List<Integer> values) {
            addCriterion("q_grade not in", values, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeBetween(Integer value1, Integer value2) {
            addCriterion("q_grade between", value1, value2, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("q_grade not between", value1, value2, "qGrade");
            return (Criteria) this;
        }

        public Criteria andQOrgIsNull() {
            addCriterion("q_org is null");
            return (Criteria) this;
        }

        public Criteria andQOrgIsNotNull() {
            addCriterion("q_org is not null");
            return (Criteria) this;
        }

        public Criteria andQOrgEqualTo(Integer value) {
            addCriterion("q_org =", value, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgNotEqualTo(Integer value) {
            addCriterion("q_org <>", value, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgGreaterThan(Integer value) {
            addCriterion("q_org >", value, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_org >=", value, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgLessThan(Integer value) {
            addCriterion("q_org <", value, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgLessThanOrEqualTo(Integer value) {
            addCriterion("q_org <=", value, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgIn(List<Integer> values) {
            addCriterion("q_org in", values, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgNotIn(List<Integer> values) {
            addCriterion("q_org not in", values, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgBetween(Integer value1, Integer value2) {
            addCriterion("q_org between", value1, value2, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQOrgNotBetween(Integer value1, Integer value2) {
            addCriterion("q_org not between", value1, value2, "qOrg");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Integer value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Integer value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Integer value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Integer value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Integer value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Integer> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Integer> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Integer value1, Integer value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("quality not between", value1, value2, "quality");
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