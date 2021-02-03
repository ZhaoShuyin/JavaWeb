package cn.day3.springjdbc._03tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"cn/day3/springjdbc/_03tx/beans.xml"
				);
		IService s = (IService)ac.getBean("accountService");
		s.transfer("aaa", "bbb", 1f);
//		s.m2();
	}

}
