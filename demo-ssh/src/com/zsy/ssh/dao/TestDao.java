package com.zsy.ssh.dao;


import com.zsy.ssh.domain.Account;

/**
 *
 */
public interface TestDao {
    Account findAccount(int id);
    void updateAccount(Account account);
    void save(Account account);
}
