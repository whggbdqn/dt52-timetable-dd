package cn.bdqn.pojo;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCoursePkIsNull() {
            addCriterion("course_pk is null");
            return (Criteria) this;
        }

        public Criteria andCoursePkIsNotNull() {
            addCriterion("course_pk is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePkEqualTo(Integer value) {
            addCriterion("course_pk =", value, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkNotEqualTo(Integer value) {
            addCriterion("course_pk <>", value, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkGreaterThan(Integer value) {
            addCriterion("course_pk >", value, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_pk >=", value, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkLessThan(Integer value) {
            addCriterion("course_pk <", value, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkLessThanOrEqualTo(Integer value) {
            addCriterion("course_pk <=", value, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkIn(List<Integer> values) {
            addCriterion("course_pk in", values, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkNotIn(List<Integer> values) {
            addCriterion("course_pk not in", values, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkBetween(Integer value1, Integer value2) {
            addCriterion("course_pk between", value1, value2, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCoursePkNotBetween(Integer value1, Integer value2) {
            addCriterion("course_pk not between", value1, value2, "coursePk");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseContentIsNull() {
            addCriterion("course_content is null");
            return (Criteria) this;
        }

        public Criteria andCourseContentIsNotNull() {
            addCriterion("course_content is not null");
            return (Criteria) this;
        }

        public Criteria andCourseContentEqualTo(String value) {
            addCriterion("course_content =", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentNotEqualTo(String value) {
            addCriterion("course_content <>", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentGreaterThan(String value) {
            addCriterion("course_content >", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentGreaterThanOrEqualTo(String value) {
            addCriterion("course_content >=", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentLessThan(String value) {
            addCriterion("course_content <", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentLessThanOrEqualTo(String value) {
            addCriterion("course_content <=", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentLike(String value) {
            addCriterion("course_content like", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentNotLike(String value) {
            addCriterion("course_content not like", value, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentIn(List<String> values) {
            addCriterion("course_content in", values, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentNotIn(List<String> values) {
            addCriterion("course_content not in", values, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentBetween(String value1, String value2) {
            addCriterion("course_content between", value1, value2, "courseContent");
            return (Criteria) this;
        }

        public Criteria andCourseContentNotBetween(String value1, String value2) {
            addCriterion("course_content not between", value1, value2, "courseContent");
            return (Criteria) this;
        }

        public Criteria andDrIsNull() {
            addCriterion("dr is null");
            return (Criteria) this;
        }

        public Criteria andDrIsNotNull() {
            addCriterion("dr is not null");
            return (Criteria) this;
        }

        public Criteria andDrEqualTo(Integer value) {
            addCriterion("dr =", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotEqualTo(Integer value) {
            addCriterion("dr <>", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThan(Integer value) {
            addCriterion("dr >", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThanOrEqualTo(Integer value) {
            addCriterion("dr >=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThan(Integer value) {
            addCriterion("dr <", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThanOrEqualTo(Integer value) {
            addCriterion("dr <=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrIn(List<Integer> values) {
            addCriterion("dr in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotIn(List<Integer> values) {
            addCriterion("dr not in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrBetween(Integer value1, Integer value2) {
            addCriterion("dr between", value1, value2, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotBetween(Integer value1, Integer value2) {
            addCriterion("dr not between", value1, value2, "dr");
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