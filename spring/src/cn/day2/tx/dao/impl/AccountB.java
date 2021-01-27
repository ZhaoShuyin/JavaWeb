package cn.day2.tx.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.day2.tx.dao.IAccount;
import cn.day2.tx.domain.Account;
import cn.day2.tx.util.TransactionManager;

public class AccountB implements IAccount {
	private QueryRunner qr = new QueryRunner();
	public Account findAccount(String sourceAccountName) {
		try {
			return qr.query(TransactionManager.getConnection(),"select * from accounts where name=?", new BeanHandler<Account>(Account.class), sourceAccountName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateAccount(Account sAccount) {
		try {
			qr.update(TransactionManager.getConnection(),"update accounts set amount=? where id=?", sAccount.getAmount(),sAccount.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
