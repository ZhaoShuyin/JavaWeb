package com.zsy.ssh.dao;


import com.zsy.ssh.domain.Account;

public interface XXXDao {
	Account findOne(Integer accountId);
	void save(Account account);
}
