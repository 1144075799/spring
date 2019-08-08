package com.spring.ui;

import com.spring.factory.BeanFactory;
import com.spring.service.AccountService;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {

        for (int i=0;i<5;i++){

            //多例
            AccountService accountService= (AccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }

    }

}
