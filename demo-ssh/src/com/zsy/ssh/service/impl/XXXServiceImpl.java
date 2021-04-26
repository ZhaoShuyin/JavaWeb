package com.zsy.ssh.service.impl;


import com.zsy.ssh.dao.XXXDao;
import com.zsy.ssh.domain.Account;
import com.zsy.ssh.service.XXXService;

public class XXXServiceImpl implements XXXService {
	private XXXDao xxxDao;
	
	public void setXxxDao(XXXDao xxxDao) {
		this.xxxDao = xxxDao;
	}

	public void doSomething() {
		System.out.println(xxxDao.findOne(1));
	}

	public void saveTest() {
		Account a1 = new Account();
		a1.setName("aaaa");
		a1.setAmount(1000f);
		xxxDao.save(a1);
//		int i=1/0;
		Account a2 = new Account();
		a2.setName("bbbb");
		a2.setAmount(1000f);
		xxxDao.save(a2);
	}
	

}
