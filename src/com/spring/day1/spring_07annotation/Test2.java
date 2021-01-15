package com.spring.day1.spring_07annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_07annotation/beans.xml");
		Bean3 bean3 = (Bean3) ac.getBean("b3");
		System.out.println(bean3);
	}
}
