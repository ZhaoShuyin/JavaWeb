package cn.day2.tx.dao;

import cn.day2.tx.domain.Account;

/**
 * 账号Dao
 */
public interface IAccount {

	//查询账号
	Account findAccount(String sourceAccountName);

	//更新账号
	void updateAccount(Account sAccount);

}
