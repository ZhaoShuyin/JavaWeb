package cn.day1.spring_05DI;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试配置构造方法
 */
public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac =
				new ClassPathXmlApplicationContext("cn/day1/spring_05DI/beans.xml");
		//通过配置构造参数创建实例
		Bean1 bean1 = (Bean1)ac.getBean("bean1");
		System.out.println("bean1:"+bean1+" ==> "+bean1.print());

		//通过Setter设置参数创建实例
		Bean2 bean2 = (Bean2)ac.getBean("bean2");
		System.out.println("bean2:"+bean2+" ==> "+bean2.print());

		//
		Bean3 bean3 = (Bean3)ac.getBean("bean3");
		System.out.println("bean3:"+bean3+" ==> "+bean3.print());
		
		Bean4 bean4 = (Bean4)ac.getBean("bean4");
		System.out.println("bean4:"+bean4+" ==> "+bean4.print());
		
		Bean5 bean5 = (Bean5)ac.getBean("bean5");
		System.out.println("bean5:"+bean5+" ==> "+bean5.getProps());
	}
}
