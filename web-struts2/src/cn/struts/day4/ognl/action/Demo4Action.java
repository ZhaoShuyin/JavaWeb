package cn.struts.day4.ognl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.opensymphony.xwork2.ActionSupport;

import cn.struts.day4.ognl.domain.Student;

public class Demo4Action extends ActionSupport {

	private List<Student> students;//列表
	
	public String execute(){
		students = new ArrayList<Student>();
		students.add(new Student("陈涔", "女", "河南省"));
		students.add(new Student("杜巍锋", "女", "河南省"));
		students.add(new Student("姜浩", "男", "山东省"));
		students.add(new Student("陈太平", "男", "四川省"));
		students.add(new Student("陈鑫", "男", "河北省"));
		return SUCCESS;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
