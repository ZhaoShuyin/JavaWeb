package spring.day1.spring_03scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/spring_03scope/beans.xml");
		UserDao userDao1 = (UserDao)ac.getBean("userDao");
		UserDao userDao2 = (UserDao)ac.getBean("userDao");
		System.out.println(userDao1==userDao2);//true
	}
}
