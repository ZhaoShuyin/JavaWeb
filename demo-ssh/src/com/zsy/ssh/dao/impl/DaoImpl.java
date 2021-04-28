package com.zsy.ssh.dao.impl;

import com.zsy.ssh.dao.TestDao;
import com.zsy.ssh.domain.Account;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 *
 */
public class DaoImpl extends HibernateDaoSupport implements TestDao {

    @Override
    public Account findAccount(int id) {
        return getHibernateTemplate().get(Account.class, id);
    }

    public void updateAccount(Account sAccount) {
        getHibernateTemplate().update(sAccount);
    }

    public void save(Account account) {
        getHibernateTemplate().save(account);
    }

}
