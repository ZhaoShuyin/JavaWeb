package com.zsy.ssh.dao;

import com.zsy.ssh.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @Title cn.day3.springjdbc._03tx
 * @date 2021/4/24
 * @autor Zsy
 */
public class RowMapper implements org.springframework.jdbc.core.RowMapper {
	//封装结果集到JavaBean中
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account a = new Account();
		a.setId(rs.getInt("id"));
		a.setName(rs.getString("name"));
		a.setAmount(rs.getFloat("amount"));
		return a;
	}
}
