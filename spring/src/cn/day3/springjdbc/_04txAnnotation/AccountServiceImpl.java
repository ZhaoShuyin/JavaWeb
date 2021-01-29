package cn.day3.springjdbc._04txAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public void transfer(String sourceAccountName, String targetAccountName,
			float money) {
		Account sAccount = accountDao.findAccount(sourceAccountName);// 每条语句都处于单独的JDBC事务中
		Account tAccount = accountDao.findAccount(targetAccountName);// 每条语句都处于单独的JDBC事务中
		sAccount.setAmount(sAccount.getAmount() - money);
		tAccount.setAmount(tAccount.getAmount() + money);
		accountDao.updateAccount(sAccount);// 每条语句都处于单独的JDBC事务中
				 int i=1/0;
		accountDao.updateAccount(tAccount);// 每条语句都处于单独的JDBC事务中
	}
	public void m1(){
		m2();
	}

	public void m2(){//当前方法
//		m1();
	}

}
