package cn.day2.tx.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import cn.day2.tx.dao.IAccount;
import cn.day2.tx.dao.impl.AccountA;
import cn.day2.tx.domain.Account;
import cn.day2.tx.service.IService;
import cn.day2.tx.util.C3P0Util;

//事务控制在业务逻辑层
public class ServiceA implements IService {
	//MySQL:事务默认是自动提交的
	public void transfer(String sourceAccountName, String targetAccountName,
			float money) {
		Connection conn = null;
		try{
			conn = C3P0Util.getConnection();
			conn.setAutoCommit(false);//开启事务
			System.out.println("=========================== 开启事务");
			 IAccount accountDao = new AccountA(conn);
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
			System.out.println("=========================== 提交事务");
			conn.commit();//提交事务
		}catch (Exception e) {
			System.out.println("========================== 异常回滚事务  "+e.toString());
			if(conn!=null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

}
