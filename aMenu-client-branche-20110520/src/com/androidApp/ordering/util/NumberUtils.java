/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.androidApp.ordering.util;

import java.math.BigDecimal;

/**
 * 类NumberUtils.java的实现描述：数字工具类
 * 
 * @author sebastien.sun 2011-8-3 上午11:28:45
 */
public class NumberUtils {

    /**
     * 转换数字到BigDecimal类型
     * 
     * @param t
     * @return
     */
    public static <T extends Number> BigDecimal convertToBigDecimal(T t) {
        return new BigDecimal(t.toString());
    }
}
