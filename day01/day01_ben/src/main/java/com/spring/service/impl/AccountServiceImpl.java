package com.spring.service.impl;

import com.spring.service.AccountService;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl(){
        System.out.println("对象被创建了");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccouont方法执行了");
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destory() {
        System.out.println("对象销毁");
    }
}
