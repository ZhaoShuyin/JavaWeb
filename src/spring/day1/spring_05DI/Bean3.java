package spring.day1.spring_05DI;

import java.util.Date;

public class Bean3 {
	private String name;
	private int age;
	private Date birthday;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String print(){
		return name+":"+age+":"+birthday.toLocaleString();
	}
}
