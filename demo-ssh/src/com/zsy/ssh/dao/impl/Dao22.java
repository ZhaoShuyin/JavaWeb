package com.zsy.ssh.dao.impl;

import com.zsy.ssh.dao.RowMapper;
import com.zsy.ssh.dao.TestDao;
import com.zsy.ssh.domain.Account;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 *
 */
public class Dao22 extends JdbcDaoSupport implements TestDao {

    @Override
    public Account findAccount(int id) {
        List<Account> list = getJdbcTemplate().query("select * from accounts where id = ?", new RowMapper(), id);
        return list.size() == 0 ? null : list.get(0);
    }

    public void updateAccount(Account sAccount) {
        getJdbcTemplate().update("update accounts set amount=? where id=?", sAccount.getAmount(), sAccount.getId());
    }

    public void save(Account account) {
        String name = account.getName();
        Float amount = account.getAmount();
        getJdbcTemplate().update("insert into accounts (name,amount) values (?,?)", name, amount);
    }

}
