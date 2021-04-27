package com.zsy.ssh.action;


import com.opensymphony.xwork2.ActionSupport;
import com.zsy.ssh.service.IService;

public class TestAction extends ActionSupport {

	private IService iService;

	public void setiService(IService iService) {
		this.iService = iService;
	}

	public String execute(){
		iService.doSomething();
		return SUCCESS;
	}
	public String saveTest(){
		iService.saveTest();
		return null;
	}
}
