package cn.day3.springjdbc._04txAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day3/springjdbc/_04txAnnotation/beans.xml");
		AccountService s = (AccountService)ac.getBean("accountService");
		s.transfer("aaa", "bbb", 1f);
	}

}
