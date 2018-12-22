/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2017 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.lw.bootdemo.common;

import tk.mybatis.mapper.MapperException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 通用的Example查询对象
 *
 * @author liuzh
 */
public class Example {
    /**
     * 排序
     */
    protected String orderByClause;

    /**
     * 去重
     */
    protected boolean distinct;

    /**
     * 查询条件
     */
    protected List<Criteria> oredCriteria;


    public void or(Criteria criteria) {
        criteria.setAndOr("or");
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        criteria.setAndOr("or");
        oredCriteria.add(criteria);
        return criteria;
    }

    public void and(Criteria criteria) {
        criteria.setAndOr("and");
        oredCriteria.add(criteria);
    }

    public Criteria and() {
        Criteria criteria = createCriteriaInternal();
        criteria.setAndOr("and");
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            criteria.setAndOr("and");
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
        /**
         * 连接条件
         */
        protected String andOr;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }


        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new MapperException("Value for condition cannot be null");
            }
            if (condition.startsWith("null")) {
                return;
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                return;
            }
            if (property == null) {
                return;
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                return;
            }
            if (property == null) {
                return;
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addOrCriterion(String condition) {
            if (condition == null) {
                throw new MapperException("Value for condition cannot be null");
            }
            if (condition.startsWith("null")) {
                return;
            }
            criteria.add(new Criterion(condition, true));
        }

        protected void addOrCriterion(String condition, Object value, String property) {
            if (value == null) {
                return;
            }
            if (property == null) {
                return;
            }
            criteria.add(new Criterion(condition, value, true));
        }

        protected void addOrCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                return;
            }
            if (property == null) {
                return;
            }
            criteria.add(new Criterion(condition, value1, value2, true));
        }

        public Criteria andIsNull(String property) {
            addCriterion(property + " is null");
            return (Criteria) this;
        }

        public Criteria andIsNotNull(String property) {
            addCriterion(property + " is not null");
            return (Criteria) this;
        }

        public Criteria andEqualTo(String property, Object value) {
            addCriterion(property + " =", value, property);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String property, Object value) {
            addCriterion(property + " <>", value, property);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String property, Object value) {
            addCriterion(property + " >", value, property);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String property, Object value) {
            addCriterion(property + " >=", value, property);
            return (Criteria) this;
        }

        public Criteria andLessThan(String property, Object value) {
            addCriterion(property + " <", value, property);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String property, Object value) {
            addCriterion(property + " <=", value, property);
            return (Criteria) this;
        }

        public Criteria andIn(String property, Iterable values) {
            addCriterion(property + " in", values, property);
            return (Criteria) this;
        }

        public Criteria andNotIn(String property, Iterable values) {
            addCriterion(property + " not in", values, property);
            return (Criteria) this;
        }

        public Criteria andBetween(String property, Object value1, Object value2) {
            addCriterion(property + " between", value1, value2, property);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String property, Object value1, Object value2) {
            addCriterion(property + " not between", value1, value2, property);
            return (Criteria) this;
        }

        public Criteria andLike(String property, String value) {
            addCriterion(property + "  like", value, property);
            return (Criteria) this;
        }

        public Criteria andNotLike(String property, String value) {
            addCriterion(property + "  not like", value, property);
            return (Criteria) this;
        }

        /**
         * 手写条件
         *
         * @param condition 例如 "length(countryname)<5"
         * @return
         */
        public Criteria andCondition(String condition) {
            addCriterion(condition);
            return (Criteria) this;
        }

        /**
         * 手写左边条件，右边用value值
         *
         * @param condition 例如 "length(countryname)="
         * @param value     例如 5
         * @return
         */
        public Criteria andCondition(String condition, Object value) {
            criteria.add(new Criterion(condition, value));
            return (Criteria) this;
        }


        public Criteria orIsNull(String property) {
            addOrCriterion(property + " is null");
            return (Criteria) this;
        }

        public Criteria orIsNotNull(String property) {
            addOrCriterion(property + " is not null");
            return (Criteria) this;
        }

        public Criteria orEqualTo(String property, Object value) {
            addOrCriterion(property + " =", value, property);
            return (Criteria) this;
        }

        public Criteria orNotEqualTo(String property, Object value) {
            addOrCriterion(property + " <>", value, property);
            return (Criteria) this;
        }

        public Criteria orGreaterThan(String property, Object value) {
            addOrCriterion(property + " >", value, property);
            return (Criteria) this;
        }

        public Criteria orGreaterThanOrEqualTo(String property, Object value) {
            addOrCriterion(property + " >=", value, property);
            return (Criteria) this;
        }

        public Criteria orLessThan(String property, Object value) {
            addOrCriterion(property + " <", value, property);
            return (Criteria) this;
        }

        public Criteria orLessThanOrEqualTo(String property, Object value) {
            addOrCriterion(property + " <=", value, property);
            return (Criteria) this;
        }

        public Criteria orIn(String property, Iterable values) {
            addOrCriterion(property + " in", values, property);
            return (Criteria) this;
        }

        public Criteria orNotIn(String property, Iterable values) {
            addOrCriterion(property + " not in", values, property);
            return (Criteria) this;
        }

        public Criteria orBetween(String property, Object value1, Object value2) {
            addOrCriterion(property + " between", value1, value2, property);
            return (Criteria) this;
        }

        public Criteria orNotBetween(String property, Object value1, Object value2) {
            addOrCriterion(property + " not between", value1, value2, property);
            return (Criteria) this;
        }

        public Criteria orLike(String property, String value) {
            addOrCriterion(property + "  like", value, property);
            return (Criteria) this;
        }

        public Criteria orNotLike(String property, String value) {
            addOrCriterion(property + "  not like", value, property);
            return (Criteria) this;
        }

        /**
         * 手写条件
         *
         * @param condition 例如 "length(countryname)<5"
         * @return
         */
        public Criteria orCondition(String condition) {
            addOrCriterion(condition);
            return (Criteria) this;
        }

        /**
         * 手写左边条件，右边用value值
         *
         * @param condition 例如 "length(countryname)="
         * @param value     例如 5
         * @return
         */
        public Criteria orCondition(String condition, Object value) {
            criteria.add(new Criterion(condition, value, true));
            return (Criteria) this;
        }


        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public String getAndOr() {
            return andOr;
        }

        public void setAndOr(String andOr) {
            this.andOr = andOr;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public boolean isValid() {
            return criteria.size() > 0;
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

        private String andOr;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            this(condition, false);
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this(condition, value, typeHandler, false);
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null, false);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this(condition, value, secondValue, typeHandler, false);
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null, false);
        }

        protected Criterion(String condition, boolean isOr) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
            this.andOr = isOr ? "or" : "and";
        }

        protected Criterion(String condition, Object value, String typeHandler, boolean isOr) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            this.andOr = isOr ? "or" : "and";
            if (value instanceof Collection<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, boolean isOr) {
            this(condition, value, null, isOr);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler, boolean isOr) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
            this.andOr = isOr ? "or" : "and";
        }

        protected Criterion(String condition, Object value, Object secondValue, boolean isOr) {
            this(condition, value, secondValue, null, isOr);
        }

        public String getAndOr() {
            return andOr;
        }

        public void setAndOr(String andOr) {
            this.andOr = andOr;
        }

        public String getCondition() {
            return condition;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        public Object getValue() {
            return value;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }
    }


    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }


    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }


}