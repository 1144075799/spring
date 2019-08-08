package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.dao.impl.AccountDaoImpl;
import com.spring.factory.BeanFactory;
import com.spring.service.AccountService;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao= (AccountDao) BeanFactory.getBean("accountDao");


    public void saveAccount() {
        accountDao.saveAccount();
    }
}
