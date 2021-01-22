package cn.day1.spring_02init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac =
				new ClassPathXmlApplicationContext("cn/day1/spring_02init/beans.xml");

		/*IUser user1 = (IUser) ac.getBean("user1");
		System.out.println("user1: "+user1);
		IUser user2 = (IUser) ac.getBean("user1");
		System.out.println("user2: "+user2);
		user1.save();*/

		IUser user3 = (IUser)ac.getBean("user2");
		System.out.println("user3: "+user3);
		IUser user4 = (IUser)ac.getBean("user2");
		System.out.println("user4: "+user4);
		user3.save();
	}
}
