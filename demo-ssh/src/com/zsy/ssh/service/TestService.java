package com.zsy.ssh.service;

import com.zsy.ssh.dao.TestDao;
import com.zsy.ssh.dao.TestDaoSupport;
import com.zsy.ssh.domain.Account;

/**
 * @Title com.zsy.ssh.service
 * @date 2021/4/26
 * @autor Zsy
 */

public class TestService {

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    private TestDao testDao;

    public void test() {
        System.out.println("================TestService.test()");
        Account account = testDao.queryBy(1);
        System.out.println("================TestService.test()  ==>   account: " + account);
    }


    private TestDaoSupport testDaoSupport;

    public void setTestDaoSupport(TestDaoSupport testDaoSupport) {
        this.testDaoSupport = testDaoSupport;
    }

    public void testSupport() {
        System.out.println("================TestService.testSupport()");
        Account account = testDaoSupport.queryById(1);
        System.out.println("================TestService.testSupport()  ==>   account: " + account);
    }

    public void transaction(){
        Account a1 = new Account();
        a1.setName("aaaa");
        a1.setAmount(1000f);
        testDao.transaction(a1);
		int i=1/0;
        Account a2 = new Account();
        a2.setName("bbbb");
        a2.setAmount(1000f);
        testDao.transaction(a2);
    }

    public void trano(){
        Account a1 = new Account();
        a1.setName("aaaa");
        a1.setAmount(1000f);
        testDaoSupport.transaction(a1);
        int i=1/0;
        Account a2 = new Account();
        a2.setName("bbbb");
        a2.setAmount(1000f);
        testDaoSupport.transaction(a2);
    }

}
