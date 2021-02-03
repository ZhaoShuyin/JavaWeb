package cn.day3.springjdbc._02daoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

//CRUD

/**
 *
 */
public class DaoImpl3 extends JdbcDaoSupport {

    public void save(Account account) {
        getJdbcTemplate().update(
                "insert into accounts (name,amount) values (?,?)",
                account.getName(), account.getAmount());
    }

    public void update(Account account) {
        getJdbcTemplate().update(
                "update accounts set name=?,amount=? where id=?",
                account.getName(), account.getAmount(), account.getId());
    }

    public void delete(Integer id) {
        getJdbcTemplate().update(
                "delete from accounts where id=?", id);
    }

    public Account findAccountById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from accounts where id=?", new RowMapper(), id);
        return accounts.size() == 0 ? null : accounts.get(0);
    }

    public List<Account> findAllAccounts() {
        List<Account> accounts = getJdbcTemplate().query("select * from accounts", new RowMapper());
        return accounts;
    }

    public Object test() {
        Account account = getJdbcTemplate().queryForObject(
                "select * from accounts limit 1",
                new org.springframework.jdbc.core.RowMapper<Account>() {
                    @Override
                    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                        Account a = new Account();
                        a.setId(resultSet.getInt("id"));
                        a.setName(resultSet.getString("name"));
                        a.setAmount(resultSet.getFloat("amount"));
                        a.setId(999);
                        return a;
                    }
                });
        return account;
    }


}


