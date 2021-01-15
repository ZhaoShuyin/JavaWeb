package com.spring.day1.spring_05DI;

/**
 * setter属性注入
 */
public class Bean2 {
	private String name;
	private int age;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String print(){
		return "Bean2 >> { name:" + name + ", age:" + age+" }";
	}
}
