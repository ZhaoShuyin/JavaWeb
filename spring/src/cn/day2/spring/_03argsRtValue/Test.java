package cn.day2.spring._03argsRtValue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day2/spring/_03argsRtValue/beans.xml");
		AccountServiceImpl accountService = (AccountServiceImpl)ac.getBean("accountService");
//		accountService.transfer("abc");
		accountService.transfer1();
//		accountService.login();
	}

}
