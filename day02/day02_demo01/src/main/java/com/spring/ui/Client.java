package com.spring.ui;


import com.spring.dao.AccountDao;
import com.spring.service.AccountService;
import com.spring.service.impl.AccountServiceImpl;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //2.根据id获取Bean对象
        AccountService accountService= (AccountService) context.getBean("accountServiceImpl");

//        System.out.println(accountService);
//
//        AccountDao accountDao=(AccountDao) context.getBean("accountDao");
//
//        System.out.println(accountDao);

        accountService.saveAccount();

    }

}
