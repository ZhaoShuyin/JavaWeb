package cn.struts.day4.resubmit.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	private String name;
	
	public String execute() throws Exception {
//		Thread.sleep(2000);
		System.out.println("name="+name);
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
