package com.zsy.ssh.dao.impl;

import com.zsy.ssh.dao.IDao;
import com.zsy.ssh.domain.Account;

import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 *
 */
public class Dao30 implements IDao {

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;

    @Override
    public Account findAccount(int id) {
        return hibernateTemplate.get(Account.class, id);
    }

    public void updateAccount(Account sAccount) {
        hibernateTemplate.update(sAccount);
    }

    public void save(Account account) {
        hibernateTemplate.save(account);
    }

}
