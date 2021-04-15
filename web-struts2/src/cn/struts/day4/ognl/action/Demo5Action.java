package cn.struts.day4.ognl.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class Demo5Action extends ActionSupport {
	private Date birthday = new Date();
	public String execute(){
		return SUCCESS;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
