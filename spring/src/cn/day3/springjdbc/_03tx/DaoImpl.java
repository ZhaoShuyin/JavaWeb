package cn.day3.springjdbc._03tx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DaoImpl extends JdbcDaoSupport implements IDao {

    public Account findAccount(String sourceAccountName) {
        List<Account> list = getJdbcTemplate().query("select * from accounts where name=?", new AccountRowMapper(), sourceAccountName);
        Account account = list.size() == 0 ? null : list.get(0);
        System.out.println(" DaoImpl ====== findAccount() { " + account.getName() + ":" + account.getAmount() + " }");
        return account;
    }

    public int updateAccount(Account sAccount) {
        int update = getJdbcTemplate().update("update accounts set amount=? where id=?", sAccount.getAmount(), sAccount.getId());
        System.out.println(" DaoImpl ======= updateAccount() { " + sAccount.getName() + ":" + sAccount.getAmount() + " } >> ( "+update+" )");
        return update;
    }

}
