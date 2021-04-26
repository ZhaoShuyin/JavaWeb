package com.zsy.ssh.dao;

import com.zsy.ssh.domain.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @Title com.zsy.ssh.dao
 * @date 2021/4/26
 * @autor Zsy
 */

public class TestDaoSupport extends HibernateDaoSupport {

    public Account queryById(Integer id) {
        System.out.println("TestDao ============ " + id);
        return getHibernateTemplate().get(Account.class, id);
    }

    public void transaction(Account account) {
        getHibernateTemplate().save(account);
    }

}
