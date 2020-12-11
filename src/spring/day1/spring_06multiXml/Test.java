package spring.day1.spring_06multiXml;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_06multiXml/beans.xml");
		Bean1 bean1 = (Bean1)ac.getBean("ddd");
		System.out.println(bean1);
	}
}
