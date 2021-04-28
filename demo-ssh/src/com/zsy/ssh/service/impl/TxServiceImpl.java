package com.zsy.ssh.service.impl;


import com.zsy.ssh.dao.TestDao;
import com.zsy.ssh.domain.Account;
import com.zsy.ssh.service.TestService;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TxServiceImpl implements TestService {

    /**
     * 使用Spring获取Dao实例
     */
    private TestDao iDao;

    public void setiDao(TestDao iDao) {
        this.iDao = iDao;
    }

    public void doSomething() {
        Account sAccount = iDao.findAccount(1);// 每条语句都处于单独的JDBC事务中
//        sAccount.setId(1);
//        iDao.updateAccount(sAccount);
    }

    /**
     * 事务测试
     */
    public void saveTest() {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCompletion(int status) {
                super.afterCompletion(status);
                System.out.println("status:" + status);
            }

            @Override
            public void beforeCommit(boolean readOnly) {
                super.beforeCommit(readOnly);
                System.out.println("readOnly:" + readOnly);
            }
        });

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
