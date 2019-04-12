package com.students.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentsprizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentsprizeExample() {
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

        public Criteria andPrizeIdIsNull() {
            addCriterion("PRIZE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIsNotNull() {
            addCriterion("PRIZE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdEqualTo(Integer value) {
            addCriterion("PRIZE_ID =", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotEqualTo(Integer value) {
            addCriterion("PRIZE_ID <>", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThan(Integer value) {
            addCriterion("PRIZE_ID >", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIZE_ID >=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThan(Integer value) {
            addCriterion("PRIZE_ID <", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRIZE_ID <=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIn(List<Integer> values) {
            addCriterion("PRIZE_ID in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotIn(List<Integer> values) {
            addCriterion("PRIZE_ID not in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdBetween(Integer value1, Integer value2) {
            addCriterion("PRIZE_ID between", value1, value2, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIZE_ID not between", value1, value2, "prizeId");
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

        public Criteria andPrizeNameIsNull() {
            addCriterion("PRIZE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNotNull() {
            addCriterion("PRIZE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameEqualTo(String value) {
            addCriterion("PRIZE_NAME =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(String value) {
            addCriterion("PRIZE_NAME <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(String value) {
            addCriterion("PRIZE_NAME >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRIZE_NAME >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(String value) {
            addCriterion("PRIZE_NAME <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(String value) {
            addCriterion("PRIZE_NAME <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLike(String value) {
            addCriterion("PRIZE_NAME like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotLike(String value) {
            addCriterion("PRIZE_NAME not like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<String> values) {
            addCriterion("PRIZE_NAME in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<String> values) {
            addCriterion("PRIZE_NAME not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(String value1, String value2) {
            addCriterion("PRIZE_NAME between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(String value1, String value2) {
            addCriterion("PRIZE_NAME not between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeDateIsNull() {
            addCriterion("PRIZE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPrizeDateIsNotNull() {
            addCriterion("PRIZE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeDateEqualTo(Date value) {
            addCriterionForJDBCDate("PRIZE_DATE =", value, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PRIZE_DATE <>", value, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PRIZE_DATE >", value, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PRIZE_DATE >=", value, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateLessThan(Date value) {
            addCriterionForJDBCDate("PRIZE_DATE <", value, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PRIZE_DATE <=", value, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateIn(List<Date> values) {
            addCriterionForJDBCDate("PRIZE_DATE in", values, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PRIZE_DATE not in", values, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PRIZE_DATE between", value1, value2, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PRIZE_DATE not between", value1, value2, "prizeDate");
            return (Criteria) this;
        }

        public Criteria andPrizeClassIsNull() {
            addCriterion("PRIZE_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andPrizeClassIsNotNull() {
            addCriterion("PRIZE_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeClassEqualTo(String value) {
            addCriterion("PRIZE_CLASS =", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassNotEqualTo(String value) {
            addCriterion("PRIZE_CLASS <>", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassGreaterThan(String value) {
            addCriterion("PRIZE_CLASS >", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassGreaterThanOrEqualTo(String value) {
            addCriterion("PRIZE_CLASS >=", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassLessThan(String value) {
            addCriterion("PRIZE_CLASS <", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassLessThanOrEqualTo(String value) {
            addCriterion("PRIZE_CLASS <=", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassLike(String value) {
            addCriterion("PRIZE_CLASS like", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassNotLike(String value) {
            addCriterion("PRIZE_CLASS not like", value, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassIn(List<String> values) {
            addCriterion("PRIZE_CLASS in", values, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassNotIn(List<String> values) {
            addCriterion("PRIZE_CLASS not in", values, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassBetween(String value1, String value2) {
            addCriterion("PRIZE_CLASS between", value1, value2, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeClassNotBetween(String value1, String value2) {
            addCriterion("PRIZE_CLASS not between", value1, value2, "prizeClass");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelIsNull() {
            addCriterion("PRIZE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelIsNotNull() {
            addCriterion("PRIZE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelEqualTo(String value) {
            addCriterion("PRIZE_LEVEL =", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelNotEqualTo(String value) {
            addCriterion("PRIZE_LEVEL <>", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelGreaterThan(String value) {
            addCriterion("PRIZE_LEVEL >", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelGreaterThanOrEqualTo(String value) {
            addCriterion("PRIZE_LEVEL >=", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelLessThan(String value) {
            addCriterion("PRIZE_LEVEL <", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelLessThanOrEqualTo(String value) {
            addCriterion("PRIZE_LEVEL <=", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelLike(String value) {
            addCriterion("PRIZE_LEVEL like", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelNotLike(String value) {
            addCriterion("PRIZE_LEVEL not like", value, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelIn(List<String> values) {
            addCriterion("PRIZE_LEVEL in", values, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelNotIn(List<String> values) {
            addCriterion("PRIZE_LEVEL not in", values, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelBetween(String value1, String value2) {
            addCriterion("PRIZE_LEVEL between", value1, value2, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevelNotBetween(String value1, String value2) {
            addCriterion("PRIZE_LEVEL not between", value1, value2, "prizeLevel");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2IsNull() {
            addCriterion("PRIZE_LEVEL2 is null");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2IsNotNull() {
            addCriterion("PRIZE_LEVEL2 is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2EqualTo(String value) {
            addCriterion("PRIZE_LEVEL2 =", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2NotEqualTo(String value) {
            addCriterion("PRIZE_LEVEL2 <>", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2GreaterThan(String value) {
            addCriterion("PRIZE_LEVEL2 >", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2GreaterThanOrEqualTo(String value) {
            addCriterion("PRIZE_LEVEL2 >=", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2LessThan(String value) {
            addCriterion("PRIZE_LEVEL2 <", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2LessThanOrEqualTo(String value) {
            addCriterion("PRIZE_LEVEL2 <=", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2Like(String value) {
            addCriterion("PRIZE_LEVEL2 like", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2NotLike(String value) {
            addCriterion("PRIZE_LEVEL2 not like", value, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2In(List<String> values) {
            addCriterion("PRIZE_LEVEL2 in", values, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2NotIn(List<String> values) {
            addCriterion("PRIZE_LEVEL2 not in", values, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2Between(String value1, String value2) {
            addCriterion("PRIZE_LEVEL2 between", value1, value2, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeLevel2NotBetween(String value1, String value2) {
            addCriterion("PRIZE_LEVEL2 not between", value1, value2, "prizeLevel2");
            return (Criteria) this;
        }

        public Criteria andPrizeFileIsNull() {
            addCriterion("PRIZE_FILE is null");
            return (Criteria) this;
        }

        public Criteria andPrizeFileIsNotNull() {
            addCriterion("PRIZE_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeFileEqualTo(String value) {
            addCriterion("PRIZE_FILE =", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileNotEqualTo(String value) {
            addCriterion("PRIZE_FILE <>", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileGreaterThan(String value) {
            addCriterion("PRIZE_FILE >", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileGreaterThanOrEqualTo(String value) {
            addCriterion("PRIZE_FILE >=", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileLessThan(String value) {
            addCriterion("PRIZE_FILE <", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileLessThanOrEqualTo(String value) {
            addCriterion("PRIZE_FILE <=", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileLike(String value) {
            addCriterion("PRIZE_FILE like", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileNotLike(String value) {
            addCriterion("PRIZE_FILE not like", value, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileIn(List<String> values) {
            addCriterion("PRIZE_FILE in", values, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileNotIn(List<String> values) {
            addCriterion("PRIZE_FILE not in", values, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileBetween(String value1, String value2) {
            addCriterion("PRIZE_FILE between", value1, value2, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeFileNotBetween(String value1, String value2) {
            addCriterion("PRIZE_FILE not between", value1, value2, "prizeFile");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroIsNull() {
            addCriterion("PRIZE_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroIsNotNull() {
            addCriterion("PRIZE_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroEqualTo(String value) {
            addCriterion("PRIZE_INTRO =", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroNotEqualTo(String value) {
            addCriterion("PRIZE_INTRO <>", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroGreaterThan(String value) {
            addCriterion("PRIZE_INTRO >", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroGreaterThanOrEqualTo(String value) {
            addCriterion("PRIZE_INTRO >=", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroLessThan(String value) {
            addCriterion("PRIZE_INTRO <", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroLessThanOrEqualTo(String value) {
            addCriterion("PRIZE_INTRO <=", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroLike(String value) {
            addCriterion("PRIZE_INTRO like", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroNotLike(String value) {
            addCriterion("PRIZE_INTRO not like", value, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroIn(List<String> values) {
            addCriterion("PRIZE_INTRO in", values, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroNotIn(List<String> values) {
            addCriterion("PRIZE_INTRO not in", values, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroBetween(String value1, String value2) {
            addCriterion("PRIZE_INTRO between", value1, value2, "prizeIntro");
            return (Criteria) this;
        }

        public Criteria andPrizeIntroNotBetween(String value1, String value2) {
            addCriterion("PRIZE_INTRO not between", value1, value2, "prizeIntro");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
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