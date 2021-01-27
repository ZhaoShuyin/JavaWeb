package cn.day2.tx.service.impl;

import cn.day2.tx.dao.IAccount;
import cn.day2.tx.dao.impl.AccountB;
import cn.day2.tx.domain.Account;
import cn.day2.tx.service.IService;
import cn.day2.tx.util.TransactionManager;
//事务控制在业务逻辑层
public class ServiceB implements IService {
	private  IAccount accountDao = new AccountB();
	//MySQL:事务默认是自动提交的
	public void transfer(String sourceAccountName, String targetAccountName,
			float money) {
		try{
			TransactionManager.startTransaction();
			//取出两个账户
			Account sAccount = accountDao.findAccount(sourceAccountName);//每条语句都处于单独的JDBC事务中
			Account tAccount = accountDao.findAccount(targetAccountName);//每条语句都处于单独的JDBC事务中
			//设置金额
			sAccount.setAmount(sAccount.getAmount()-money);
			tAccount.setAmount(tAccount.getAmount()+money);
			//更新账户
			accountDao.updateAccount(sAccount);//每条语句都处于单独的JDBC事务中
//				int i=1/0;
			accountDao.updateAccount(tAccount);//每条语句都处于单独的JDBC事务中
			TransactionManager.commit();//提交事务
		}catch (Exception e) {
			System.out.println("异常 >>> "+e.toString());
			TransactionManager.rollback();
		}finally{
			TransactionManager.release();
		}
	}
	//1、代码重复，事务控制有关的代码
	//2、别人写好的代码。无法修改，我们需要事务。
	
}
