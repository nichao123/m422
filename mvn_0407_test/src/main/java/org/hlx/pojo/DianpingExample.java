package org.hlx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DianpingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DianpingExample() {
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

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andFoodidIsNull() {
            addCriterion("foodId is null");
            return (Criteria) this;
        }

        public Criteria andFoodidIsNotNull() {
            addCriterion("foodId is not null");
            return (Criteria) this;
        }

        public Criteria andFoodidEqualTo(Integer value) {
            addCriterion("foodId =", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotEqualTo(Integer value) {
            addCriterion("foodId <>", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidGreaterThan(Integer value) {
            addCriterion("foodId >", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidGreaterThanOrEqualTo(Integer value) {
            addCriterion("foodId >=", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidLessThan(Integer value) {
            addCriterion("foodId <", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidLessThanOrEqualTo(Integer value) {
            addCriterion("foodId <=", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidIn(List<Integer> values) {
            addCriterion("foodId in", values, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotIn(List<Integer> values) {
            addCriterion("foodId not in", values, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidBetween(Integer value1, Integer value2) {
            addCriterion("foodId between", value1, value2, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotBetween(Integer value1, Integer value2) {
            addCriterion("foodId not between", value1, value2, "foodid");
            return (Criteria) this;
        }

        public Criteria andKouweiIsNull() {
            addCriterion("kouwei is null");
            return (Criteria) this;
        }

        public Criteria andKouweiIsNotNull() {
            addCriterion("kouwei is not null");
            return (Criteria) this;
        }

        public Criteria andKouweiEqualTo(String value) {
            addCriterion("kouwei =", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiNotEqualTo(String value) {
            addCriterion("kouwei <>", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiGreaterThan(String value) {
            addCriterion("kouwei >", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiGreaterThanOrEqualTo(String value) {
            addCriterion("kouwei >=", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiLessThan(String value) {
            addCriterion("kouwei <", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiLessThanOrEqualTo(String value) {
            addCriterion("kouwei <=", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiLike(String value) {
            addCriterion("kouwei like", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiNotLike(String value) {
            addCriterion("kouwei not like", value, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiIn(List<String> values) {
            addCriterion("kouwei in", values, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiNotIn(List<String> values) {
            addCriterion("kouwei not in", values, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiBetween(String value1, String value2) {
            addCriterion("kouwei between", value1, value2, "kouwei");
            return (Criteria) this;
        }

        public Criteria andKouweiNotBetween(String value1, String value2) {
            addCriterion("kouwei not between", value1, value2, "kouwei");
            return (Criteria) this;
        }

        public Criteria andDpcontentIsNull() {
            addCriterion("dpcontent is null");
            return (Criteria) this;
        }

        public Criteria andDpcontentIsNotNull() {
            addCriterion("dpcontent is not null");
            return (Criteria) this;
        }

        public Criteria andDpcontentEqualTo(String value) {
            addCriterion("dpcontent =", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentNotEqualTo(String value) {
            addCriterion("dpcontent <>", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentGreaterThan(String value) {
            addCriterion("dpcontent >", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentGreaterThanOrEqualTo(String value) {
            addCriterion("dpcontent >=", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentLessThan(String value) {
            addCriterion("dpcontent <", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentLessThanOrEqualTo(String value) {
            addCriterion("dpcontent <=", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentLike(String value) {
            addCriterion("dpcontent like", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentNotLike(String value) {
            addCriterion("dpcontent not like", value, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentIn(List<String> values) {
            addCriterion("dpcontent in", values, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentNotIn(List<String> values) {
            addCriterion("dpcontent not in", values, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentBetween(String value1, String value2) {
            addCriterion("dpcontent between", value1, value2, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andDpcontentNotBetween(String value1, String value2) {
            addCriterion("dpcontent not between", value1, value2, "dpcontent");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andDpdateIsNull() {
            addCriterion("dpdate is null");
            return (Criteria) this;
        }

        public Criteria andDpdateIsNotNull() {
            addCriterion("dpdate is not null");
            return (Criteria) this;
        }

        public Criteria andDpdateEqualTo(Date value) {
            addCriterionForJDBCDate("dpdate =", value, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("dpdate <>", value, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateGreaterThan(Date value) {
            addCriterionForJDBCDate("dpdate >", value, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dpdate >=", value, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateLessThan(Date value) {
            addCriterionForJDBCDate("dpdate <", value, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dpdate <=", value, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateIn(List<Date> values) {
            addCriterionForJDBCDate("dpdate in", values, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("dpdate not in", values, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dpdate between", value1, value2, "dpdate");
            return (Criteria) this;
        }

        public Criteria andDpdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dpdate not between", value1, value2, "dpdate");
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