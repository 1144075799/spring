package com.spring.test;

import com.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试aop的测试
 */
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        //2.获取对象
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        //3.执行方法
        //3.1执行保存操作
        accountService.saveAccount();
        //3.2执行更新操作
        accountService.updateAccount(1);
        //3.3执行删除操作
        accountService.deletedAccount();
    }
}
