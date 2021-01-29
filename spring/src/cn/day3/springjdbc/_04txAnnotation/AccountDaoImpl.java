package cn.day3.springjdbc._04txAnnotation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImpl  implements AccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Account findAccount(String sourceAccountName) {
		List<Account> list = jdbcTemplate.query("select * from accounts where name=?", new AccountRowMapper(), sourceAccountName);
		return list.size()==0?null:list.get(0);
		
	}

	public void updateAccount(Account sAccount) {
		jdbcTemplate.update("update accounts set amount=? where id=?",sAccount.getAmount(),sAccount.getId());
	}

}
class AccountRowMapper implements RowMapper<Account>{
	//封装结果集到JavaBean中
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account a = new Account();
		a.setId(rs.getInt("id"));
		a.setName(rs.getString("name"));
		a.setAmount(rs.getFloat("amount"));
		return a;
	}
}
