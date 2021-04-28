package com.zsy.ssh.action;


import com.opensymphony.xwork2.ActionSupport;
import com.zsy.ssh.service.TestService;

public class TestAction extends ActionSupport {

	private TestService testService;

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	public String execute(){
		testService.doSomething();
		return SUCCESS;
	}
	public String saveTest(){
		testService.saveTest();
		return null;
	}
}
