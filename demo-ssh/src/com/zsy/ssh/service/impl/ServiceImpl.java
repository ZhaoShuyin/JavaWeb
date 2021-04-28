package com.zsy.ssh.service.impl;


import com.zsy.ssh.dao.TestDao;
import com.zsy.ssh.domain.Account;
import com.zsy.ssh.service.TestService;

public class ServiceImpl implements TestService {

    /**
     * 使用Spring获取Dao实例
     */
    private TestDao testDao;

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    /**
     *
     */
    public void doSomething() {
        Account sAccount = testDao.findAccount(1);// 每条语句都处于单独的JDBC事务中
        Account tAccount = testDao.findAccount(2);// 每条语句都处于单独的JDBC事务中
        sAccount.setAmount(sAccount.getAmount() - 1);
        tAccount.setAmount(tAccount.getAmount() + 1);
        testDao.updateAccount(sAccount);// 每条语句都处于单独的JDBC事务中
        int i=1/0;
        testDao.updateAccount(tAccount);// 每条语句都处于单独的JDBC事务中
    }

    /**
     * 事务测试
     */
    public void saveTest() {
        Account a1 = new Account();
        a1.setName("aaaa");
        a1.setAmount(1000f);
        testDao.save(a1);
//        int i = 1 / 0;
        Account a2 = new Account();
        a2.setName("bbbb");
        a2.setAmount(1000f);
        testDao.save(a2);
    }


}
