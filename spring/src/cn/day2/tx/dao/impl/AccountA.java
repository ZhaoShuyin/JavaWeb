package cn.day2.tx.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.day2.tx.dao.IAccount;
import cn.day2.tx.domain.Account;

public class AccountA implements IAccount {

	private QueryRunner qr = new QueryRunner();

	/**
	 * 构造函数传递Sql连接
	 */
	private Connection conn;
	public AccountA(Connection conn){
		this.conn = conn;
	}

	public Account findAccount(String sourceAccountName) {
		try {
			return qr.query(conn,"select * from accounts where name=?", new BeanHandler<Account>(Account.class), sourceAccountName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateAccount(Account sAccount) {
		try {
			qr.update(conn,"update accounts set amount=? where id=?", sAccount.getAmount(),sAccount.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
