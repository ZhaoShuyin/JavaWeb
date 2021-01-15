package com.spring.day1.spring_07annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_07annotation/beans.xml");
		Bean2 bean2 = (Bean2) ac.getBean("bean2");
		ac.close();
	}
}
