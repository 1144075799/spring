package com.spring.utils;

/**
 * 用户记录日志的工具类
 * 它里面提供了公共的方法
 */
public class Logger {
    /**
     * 用于打印日志，并且让其在切入点方法执行之前执行
     * (切入点方法就是业务层方法)
     */
    public void printLog(){
        System.out.println("Logger类中的printLog开始记录日志的");
    }
}
