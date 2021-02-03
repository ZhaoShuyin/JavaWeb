package cn.day3.springjdbc._03tx;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title cn.day3.springjdbc._03tx
 */
public class AccountRowMapper implements RowMapper<Account> {

	//封装结果集到JavaBean中
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//		System.out.println("================== mapRow");
		Account a = new Account();
		a.setId(rs.getInt("id"));
		a.setName(rs.getString("name"));
		a.setAmount(rs.getFloat("amount"));
		return a;
	}
}
