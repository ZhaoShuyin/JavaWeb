package cn.day3.springjdbc._03tx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DaoImpl extends JdbcDaoSupport implements IDao {

    public Account findAccount(String sourceAccountName) {
        System.out.println(" DaoImpl ======================= findAccount()");
        List<Account> list = getJdbcTemplate().query("select * from accounts where name=?", new AccountRowMapper(), sourceAccountName);
        return list.size() == 0 ? null : list.get(0);
    }

    public void updateAccount(Account sAccount) {
        System.out.println(" DaoImpl ======================= updateAccount()");
        getJdbcTemplate().update("update accounts set amount=? where id=?", sAccount.getAmount(), sAccount.getId());
    }

}
