package com.zsy.ssh.test;

import com.zsy.ssh.domain.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Title com.zsy.ssh.test
 * @date 2021/4/26
 * @autor Zsy
 */

public class Test {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, 1);
        session.close();
        sessionFactory.close();
        System.out.println("account : "+account);
    }


    //select account0_.ID as ID1_0_0_, account0_.NAME as NAME2_0_0_, account0_.AMOUNT as AMOUNT3_0_0_ from ACCOUNTS account0_ where account0_.ID=?
    //select account0_.ID as ID1_0_0_, account0_.NAME as NAME2_0_0_, account0_.AMOUNT as AMOUNT3_0_0_ from ACCOUNTS account0_ where account0_.ID=1;
}
