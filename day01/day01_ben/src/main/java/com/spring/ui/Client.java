package com.spring.ui;


import com.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {


    /**
     * 获取spring的ioc核心容器
     * @param args
     */
    public static void main(String[] args) {


        //1.获取核心容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //2.根据id获取Bean对象

        AccountService accountService= (AccountService) context.getBean("accountService");

//        System.out.println(accountService);

        accountService.saveAccount();

        //手动释放容器
        context.close();


    }

}
