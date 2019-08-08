package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.domain.Account;
import com.spring.service.AccountService;
import com.spring.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccounntServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionManager transactionManager;


    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {

        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e){
            //5.回滚操作
            transactionManager.commit();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.release();
        }


    }

    public Account findAccountById(Integer id) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(id);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚操作
            transactionManager.commit();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.release();
        }

    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();

        }catch (Exception e){
            //5.回滚操作
            transactionManager.commit();
        }finally {
            //6.释放资源
            transactionManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();

        }catch (Exception e){
            //5.回滚操作
            transactionManager.commit();
        }finally {
            //6.释放资源
            transactionManager.release();
        }

    }

    public void deleteAccount(Integer id) {

        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            transactionManager.commit();

        }catch (Exception e){
            //5.回滚操作
            transactionManager.commit();
        }finally {
            //6.释放资源
            transactionManager.release();
        }


    }

    public void transfor(String sourceName, String targetName, float money) {


        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            //1.根据名称查询转出账户
            Account source=accountDao.findAccountByName(sourceName);
            //2.根据名称查询转入账户
            Account target=accountDao.findAccountByName(targetName);
            //3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //5.更新转出账户
            accountDao.updateAccount(source);

            int i=1/0;

            //6.更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            transactionManager.commit();

        }catch (Exception e){
            //5.回滚操作
            transactionManager.commit();
            e.printStackTrace();
        }finally {
            //6.释放资源
            transactionManager.release();
        }


    }
}
