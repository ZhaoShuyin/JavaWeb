package com.zsy.ssh.dao.impl;

import com.zsy.ssh.dao.XXXDao;
import com.zsy.ssh.domain.Account;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


public class XXXDaoImpl extends HibernateDaoSupport implements XXXDao {
	public Account findOne(Integer accountId) {
		return getHibernateTemplate().get(Account.class, accountId);
	}
	public void save(Account account) {
		getHibernateTemplate().save(account);
	}

}
