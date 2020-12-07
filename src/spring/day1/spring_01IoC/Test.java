package spring.day1.spring_01IoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//ApplicationContext:非常重要的接口，用来操作Spring容器
		//ClassPathXmlApplicationContext:配置文件是在classpath中的
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_01IoC/beans.xml");//初始化Spring容器
		UserService userService = (UserService)ac.getBean("userService");                                  //从spring容器中根据bean的名称获取对象
		userService.regist();
		
//		Resource resource = new ClassPathResource("spring/day1/ioc/beans.xml");
//		BeanFactory bf = new XmlBeanFactory(resource);//Resource:把配置文件看做资源，可以使用通配符
//		UserService userService = (UserService)bf.getBean("userService");//从spring容器中根据bean的名称获取对象
//		userService.regist();
	}
}
