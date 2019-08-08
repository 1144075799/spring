package com.spring.service;

import com.spring.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */

public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     *转账
     * @param sourceName    转出账户名称
     * @param targetName    转入账户名称
     * @param money         转账金额
     */
    void transfor(String sourceName,String targetName,float money);
}
