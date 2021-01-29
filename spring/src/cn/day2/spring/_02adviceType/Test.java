package cn.day2.spring._02adviceType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day2/spring/_02adviceType/beans.xml");
		ServiceImpl accountService = (ServiceImpl)ac.getBean("accountService");
		accountService.transfer();
		System.out.println("==============================");
		accountService.transfer1();
	}

}
