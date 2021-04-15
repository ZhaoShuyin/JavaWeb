package cn.struts.day4.ognl.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo6Action extends ActionSupport {
//	private String name = "Demo6Action";
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("name", "oldrequest");
		ActionContext ac = ActionContext.getContext();
		ac.put("name", "contextMap");
		return SUCCESS;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	
}
