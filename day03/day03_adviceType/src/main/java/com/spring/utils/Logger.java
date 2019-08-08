package com.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用户记录日志的工具类
 * 它里面提供了公共的方法
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforeLog(){
        System.out.println("前置通知beforeLog");
    }

    /**
     * 后置通知
     */
    public void afterLog(){
        System.out.println("后置通知afterLog");
    }

    /**
     * 最终通知
     */
    public void finallLog(){
        System.out.println("最终通知finallLog");
    }

    /**
     * 异常通知
     */
    public void throwLog(){
        System.out.println("异常通知throwLog");
    }

    /**
     * 环绕通知
     */
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint){
        Object rtValue=null;
        try {
            Object[] args=proceedingJoinPoint.getArgs();    //得到方法执行的参数
            System.out.println("环绕通知aroundLog");        //前置通知
            rtValue=proceedingJoinPoint.proceed();//明确调用业务层方法
            System.out.println("环绕通知aroundLog");       //后置通知
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知aroundLog");        //异常通知
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("环绕通知aroundLog");        //最终通知
        }


    }

}
