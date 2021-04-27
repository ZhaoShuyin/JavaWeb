package com.zsy.ssh.dao.impl;

import com.zsy.ssh.dao.RowMapper;
import com.zsy.ssh.dao.IDao;
import com.zsy.ssh.domain.Account;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 *
 */
public class Dao2 implements IDao {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccount(int id) {
        List<Account> list = jdbcTemplate.query("select * from accounts where id = ?", new RowMapper(), id);
        return list.size() == 0 ? null : list.get(0);
    }

    public void updateAccount(Account sAccount) {
        jdbcTemplate.update("update accounts set amount=? where id=?", sAccount.getAmount(), sAccount.getId());
    }

    public void save(Account account) {
        String name = account.getName();
        Float amount = account.getAmount();
        jdbcTemplate.update("insert into accounts (name,amount) values (?,?)", name, amount);
    }

}
