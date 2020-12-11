package spring.day1.spring_07annotation;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_07annotation/beans.xml");
//		Bean1 bean1 = (Bean1)ac.getBean("bb1");
//		System.out.println(bean1);
		
//		UserDaoImpl userdao = (UserDaoImpl)ac.getBean("userDao");
//		userdao.save();
		
//		UserServiceImpl userService = (UserServiceImpl)ac.getBean("userService");
//		userService.regist();
		
		UserAction userAction = (UserAction)ac.getBean("userAction");
		userAction.execute();
	}
}
