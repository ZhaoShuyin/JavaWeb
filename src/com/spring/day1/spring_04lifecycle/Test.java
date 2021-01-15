package com.spring.day1.spring_04lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * <bean></>中的 init-method标签 和 destroy-method标签
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_04lifecycle/beans.xml");
		UserDao userDao1 = (UserDao)ac.getBean("userDao");
		UserDao userDao2 = (UserDao)ac.getBean("userDao");
		ac.close();
	}
}
