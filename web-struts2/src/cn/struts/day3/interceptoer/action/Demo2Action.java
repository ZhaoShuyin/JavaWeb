package cn.struts.day3.interceptoer.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	//要求用户必须先登陆
	public String save(){
		System.out.println("执行了save方法");
		return null;
	}
	//要求用户必须先登陆
	public String update(){
		System.out.println("执行了update方法");
		return null;
	}
	//用户登陆
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "aaaa");//设置登陆标记
		return SUCCESS;
	}
}
