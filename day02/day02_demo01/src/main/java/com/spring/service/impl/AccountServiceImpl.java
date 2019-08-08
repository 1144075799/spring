package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


/**
 * 曾经xml配置:
 *  <bean id="accountService" class="com.spring.service.impl.AccountServiceImpl"
 *      scope="" init-method="" destory-method="">
 *      <property name="" value="" / ref="" ></property>
 *  </bean>
 *
 * 账户的业务层实现类
 */
@Controller
public class AccountServiceImpl implements AccountService {

//    @Autowired
//    @Qualifier(value = "accountDao2")
    @Resource(name = "accountDao1")
    private AccountDao accountDao2;


    public void saveAccount() {
        accountDao2.saveAccount();
    }
}
