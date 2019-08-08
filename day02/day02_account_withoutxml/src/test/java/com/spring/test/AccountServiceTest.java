package com.spring.test;


import com.spring.domain.Account;
import com.spring.service.AccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试 测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {


    @Autowired
    private AccountService accountService;



    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts=accountService.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

        //3.执行方法
        Account account=accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("ddd");
        account.setMoney(40000f);

        //3.执行方法
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        //3.执行方法
        Account account=accountService.findAccountById(5);
        account.setMoney(80000f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {

        //3.执行方法
        accountService.deleteAccount(5);
    }
}
