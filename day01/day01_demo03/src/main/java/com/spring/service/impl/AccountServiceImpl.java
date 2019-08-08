package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.dao.impl.AccountDaoImpl;
import com.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao=new AccountDaoImpl();


    public void saveAccount() {
        accountDao.saveAccount();
    }
}
