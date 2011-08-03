/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.androidApp.ordering.util;

import java.math.BigDecimal;

/**
 * 类MathUtils.java的实现描述：数学工具类.提供精确的运算
 * 
 * @author sebastien.sun 2011-8-3 上午11:20:45
 */
public class MathUtils {

    /* 默认除法运算精度.2即为小数点后2位 */
    private static final int DEFAULT_SCALE = 2;

    /**
     * 两个数字相加
     * 
     * @param v1
     * @param v2
     * @return Float
     */
    public static Float add(Float v1, Float v2) {
        return addByAndType(v1, v2).floatValue();
    }

    /**
     * 两个数字相减
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static Float subtract(Float v1, Float v2) {
        return subtractByAndType(v1, v2).floatValue();
    }

    /**
     * 两个数字相乘
     * 
     * @param v1
     * @param v2
     * @return Float
     */
    public static Float multiply(Float v1, Float v2) {
        return multiplyByAndType(v1, v2).floatValue();
    }

    /**
     * 两个数字相除
     * 
     * @param v1
     * @param v2
     * @return Float
     */
    public static Float divide(Float v1, Float v2) {
        return divideByAndType(v1, v2, DEFAULT_SCALE).floatValue();
    }

    /**
     * 两个数字相除
     * 
     * @param v1
     * @param v2
     * @param scale 表示表示需要精确到小数点以后几位
     * 
     * <pre>
     * 比如scale为2时，就表示精确到小数点后2位。返回类似1.32这样的精度
     * </pre>
     * @return Float
     */
    public static Float divide(Float v1, Float v2, int scale) {
        return divideByAndType(v1, v2, scale).floatValue();
    }

    /**
     * 兩個数字相加
     * 
     * @param v1
     * @param v2
     * @return BigDecimal
     */
    public static <T extends Number> BigDecimal addByAndType(T v1, T v2) {
        if (v1 == null || v2 == null) {
            throw new NullPointerException("v1 and v2 cant be null!");
        }

        BigDecimal b1 = NumberUtils.convertToBigDecimal(v1);
        BigDecimal b2 = NumberUtils.convertToBigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * 两个数相减
     * 
     * @param v1
     * @param v2
     * @return
     */
    public static <T extends Number> BigDecimal subtractByAndType(T v1, T v2) {
        if (v1 == null || v2 == null) {
            throw new NullPointerException("v1 and v2 cant be null!");
        }

        BigDecimal b1 = NumberUtils.convertToBigDecimal(v1);
        BigDecimal b2 = NumberUtils.convertToBigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * 两个数字相乘
     * 
     * @param v1
     * @param v2
     * @return BigDecimal
     */
    public static <T extends Number> BigDecimal multiplyByAndType(T v1, T v2) {
        if (v1 == null || v2 == null) {
            throw new NullPointerException("v1 and v2 cant be null!");
        }

        BigDecimal b1 = NumberUtils.convertToBigDecimal(v1);
        BigDecimal b2 = NumberUtils.convertToBigDecimal(v2);

        return b1.multiply(b2);
    }

    /**
     * 两个数字相除
     * 
     * @param v1
     * @param v2
     * @param scale 表示表示需要精确到小数点以后几位
     * @return BigDecimal
     */
    public static <T extends Number> BigDecimal divideByAndType(T v1, T v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }

        if (v1 == null || v2 == null) {
            throw new NullPointerException("v1 and v2 cant be null!");
        }

        BigDecimal b1 = NumberUtils.convertToBigDecimal(v1);
        BigDecimal b2 = NumberUtils.convertToBigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        float x = MathUtils.add(3.4f, 4.5f);
        System.out.println(x);
    }
}
