package cn.day3.springjdbc._04txAnnotation;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountService {
	/**
	 * 转账
	 * @param sourceAccountName 转出账户名
	 * @param targetAccountName 转入账户名
	 * @param money 金额
	 */
	void transfer(String sourceAccountName, String targetAccountName, float money);
	void m1();
	void m2();
}
