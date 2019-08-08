package com.spring.service.impl;

import com.spring.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {


    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deletedAccount() {
        System.out.println("执行的删除");
        return 0;
    }
}
