package com.zsy.ssh.service.impl;


import com.zsy.ssh.dao.IDao;
import com.zsy.ssh.domain.Account;
import com.zsy.ssh.service.IService;

public class ServiceImpl implements IService {

    /**
     * 使用Spring获取Dao实例
     */
    private IDao iDao;

    public void setiDao(IDao iDao) {
        this.iDao = iDao;
    }

    public void doSomething() {
        Account sAccount = iDao.findAccount(1);// 每条语句都处于单独的JDBC事务中
        Account tAccount = iDao.findAccount(2);// 每条语句都处于单独的JDBC事务中
        sAccount.setAmount(sAccount.getAmount() - 1);
        tAccount.setAmount(tAccount.getAmount() + 1);
        iDao.updateAccount(sAccount);// 每条语句都处于单独的JDBC事务中
        int i=1/0;
        iDao.updateAccount(tAccount);// 每条语句都处于单独的JDBC事务中
    }

    /**
     * 事务测试
     */
    public void saveTest() {
        Account a1 = new Account();
        a1.setName("aaaa");
        a1.setAmount(1000f);
        iDao.save(a1);
//        int i = 1 / 0;
        Account a2 = new Account();
        a2.setName("bbbb");
        a2.setAmount(1000f);
        iDao.save(a2);
    }


}
