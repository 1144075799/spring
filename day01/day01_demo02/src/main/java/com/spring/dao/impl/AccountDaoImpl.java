package com.spring.dao.impl;


import com.spring.dao.AccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
