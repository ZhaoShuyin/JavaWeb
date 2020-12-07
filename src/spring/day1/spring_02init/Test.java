package spring.day1.spring_02init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/spring_02init/beans.xml");
		UserDao userDao = (UserDao)ac.getBean("userDao2");
		userDao.save();
	}
}
