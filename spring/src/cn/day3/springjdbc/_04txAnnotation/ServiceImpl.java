package cn.day3.springjdbc._04txAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class ServiceImpl implements IService {

	//@Repository 使用注解获取 DaoImpl 对象
	@Autowired
	private IDao dao;

	public ServiceImpl() {
		System.out.println("构造函数 : ServiceImpl");
	}

	public boolean transfer(String sourceAccountName, String targetAccountName,
						 float money) {
		Account sAccount = dao.findAccount(sourceAccountName);
		Account tAccount = dao.findAccount(targetAccountName);
		sAccount.setAmount(sAccount.getAmount() - money);
		tAccount.setAmount(tAccount.getAmount() + money);
		dao.updateAccount(sAccount);
//				 int i=1/0;
		dao.updateAccount(tAccount);
		return true;
	}

	public void m1(){
		m2();
	}

	public void m2(){//当前方法
//		m1();
	}

}
