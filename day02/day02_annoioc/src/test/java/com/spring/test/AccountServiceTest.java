package com.spring.test;


import com.spring.domain.Account;
import com.spring.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试 测试我们的配置
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        //1.获取容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        //2.得到业务层对象
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        //3.执行方法
        List<Account> accounts=accountService.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //1.获取容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        //2.得到业务层对象
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        //3.执行方法
        Account account=accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("ddd");
        account.setMoney(4000f);
        //1.获取容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        //2.得到业务层对象
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        //3.执行方法
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //1.获取容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        //2.得到业务层对象
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        //3.执行方法
        Account account=accountService.findAccountById(4);
        account.setMoney(40000f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //1.获取容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        //2.得到业务层对象
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        //3.执行方法
        accountService.deleteAccount(4);
    }
}
