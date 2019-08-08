package com.spring.factory;

import com.spring.service.AccountService;
import com.spring.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类，该类可能存在于Jar包中，
 * 我们无法通过修改源码的方式来提供默认构造函数
 *
 */
public class InstanceFactory {

    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }

}
