package org.hlx.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FoodinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodinfoExample() {
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

        public Criteria andFoodnameIsNull() {
            addCriterion("foodName is null");
            return (Criteria) this;
        }

        public Criteria andFoodnameIsNotNull() {
            addCriterion("foodName is not null");
            return (Criteria) this;
        }

        public Criteria andFoodnameEqualTo(String value) {
            addCriterion("foodName =", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotEqualTo(String value) {
            addCriterion("foodName <>", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameGreaterThan(String value) {
            addCriterion("foodName >", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameGreaterThanOrEqualTo(String value) {
            addCriterion("foodName >=", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameLessThan(String value) {
            addCriterion("foodName <", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameLessThanOrEqualTo(String value) {
            addCriterion("foodName <=", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameLike(String value) {
            addCriterion("foodName like", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotLike(String value) {
            addCriterion("foodName not like", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameIn(List<String> values) {
            addCriterion("foodName in", values, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotIn(List<String> values) {
            addCriterion("foodName not in", values, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameBetween(String value1, String value2) {
            addCriterion("foodName between", value1, value2, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotBetween(String value1, String value2) {
            addCriterion("foodName not between", value1, value2, "foodname");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andFoodpriceIsNull() {
            addCriterion("foodPrice is null");
            return (Criteria) this;
        }

        public Criteria andFoodpriceIsNotNull() {
            addCriterion("foodPrice is not null");
            return (Criteria) this;
        }

        public Criteria andFoodpriceEqualTo(BigDecimal value) {
            addCriterion("foodPrice =", value, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceNotEqualTo(BigDecimal value) {
            addCriterion("foodPrice <>", value, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceGreaterThan(BigDecimal value) {
            addCriterion("foodPrice >", value, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("foodPrice >=", value, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceLessThan(BigDecimal value) {
            addCriterion("foodPrice <", value, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("foodPrice <=", value, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceIn(List<BigDecimal> values) {
            addCriterion("foodPrice in", values, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceNotIn(List<BigDecimal> values) {
            addCriterion("foodPrice not in", values, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foodPrice between", value1, value2, "foodprice");
            return (Criteria) this;
        }

        public Criteria andFoodpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foodPrice not between", value1, value2, "foodprice");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andFoodimageIsNull() {
            addCriterion("foodImage is null");
            return (Criteria) this;
        }

        public Criteria andFoodimageIsNotNull() {
            addCriterion("foodImage is not null");
            return (Criteria) this;
        }

        public Criteria andFoodimageEqualTo(String value) {
            addCriterion("foodImage =", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageNotEqualTo(String value) {
            addCriterion("foodImage <>", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageGreaterThan(String value) {
            addCriterion("foodImage >", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageGreaterThanOrEqualTo(String value) {
            addCriterion("foodImage >=", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageLessThan(String value) {
            addCriterion("foodImage <", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageLessThanOrEqualTo(String value) {
            addCriterion("foodImage <=", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageLike(String value) {
            addCriterion("foodImage like", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageNotLike(String value) {
            addCriterion("foodImage not like", value, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageIn(List<String> values) {
            addCriterion("foodImage in", values, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageNotIn(List<String> values) {
            addCriterion("foodImage not in", values, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageBetween(String value1, String value2) {
            addCriterion("foodImage between", value1, value2, "foodimage");
            return (Criteria) this;
        }

        public Criteria andFoodimageNotBetween(String value1, String value2) {
            addCriterion("foodImage not between", value1, value2, "foodimage");
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