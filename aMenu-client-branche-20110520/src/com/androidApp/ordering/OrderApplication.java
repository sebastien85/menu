/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.androidApp.ordering;

import android.app.Application;
import android.os.Build;
import dalvik.system.VMRuntime;

/**
 * 类OrderApplication.java的实现描述：自定义Application<br />
 * 
 * <pre>
 * TODO 
 * 1.是否要自己管理activity，方便各版本系统都能直接全部退出所有activity.
 * 2.在低电的情况下，是否要做保存什么东西的处理。
 * 3.一些业务数据的初始化
 * 4.屏幕分辨率是否要处理
 * </pre>
 * 
 * @author sebastien.sun 2011-8-3 下午1:39:58
 */
public class OrderApplication extends Application {

    /*
     * (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();
        checkSystemVersioin();// 检查系统版本
        setVM();// 设置VM堆
    }

    /*
     * TODO 可以在此处理释放缓存等操作 (non-Javadoc)
     * @see android.app.Application#onLowMemory()
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * 设置Dalvik VM
     */
    private void setVM() {
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);// 增强程序堆内存的处理效率
        VMRuntime.getRuntime().setMinimumHeapSize(4 * 1024 * 1024);// 设置最小堆内存为4M
    }

    /**
     * 检查系统版本 <br />
     * TODO 需要对低版本进行处理(是否可以降级处理？)
     */
    @SuppressWarnings("unused")
    private void checkSystemVersioin() {
        String systemVersion = Build.VERSION.RELEASE;
    }
}
