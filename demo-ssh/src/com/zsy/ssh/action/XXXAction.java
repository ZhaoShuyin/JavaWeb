package com.zsy.ssh.action;


import com.opensymphony.xwork2.ActionSupport;
import com.zsy.ssh.service.XXXService;

public class XXXAction extends ActionSupport {
	private XXXService xxxService;
	public void setXxxService(XXXService xxxService) {
		this.xxxService = xxxService;
	}
	public String execute(){
		xxxService.doSomething();
		return SUCCESS;
	}
	public String saveTest(){
		xxxService.saveTest();
		return null;
	}
}
