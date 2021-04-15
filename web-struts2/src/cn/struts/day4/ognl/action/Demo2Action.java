package cn.struts.day4.ognl.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * OGNL 使用 if elseif else 表达式
 */
public class Demo2Action extends ActionSupport {
	private String name = "陈涔";
	private String grade = "A";//成绩
	public String execute(){
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
