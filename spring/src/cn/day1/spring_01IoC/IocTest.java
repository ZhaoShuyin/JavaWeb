package cn.day1.spring_01IoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC控制反转
 */
public class IocTest {

	public static void main(String[] args) {
		//ApplicationContext:非常重要的接口，用来操作Spring容器
		//ClassPathXmlApplicationContext:配置文件是在classpath中的

		//初始化Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day1/spring_01IoC/beans.xml");
		//从spring容器中根据bean的名称获取对象
		IService userService = (IService)ac.getBean("service");
		userService.regist();
		
//		Resource resource = new ClassPathResource("cn/itcast/spring_01IoC/beans.xml");
//		BeanFactory bf = new XmlBeanFactory(resource);//Resource:把配置文件看做资源，可以使用通配符
//		UserService userService = (UserService)bf.getBean("userService");//从spring容器中根据bean的名称获取对象
//		userService.regist();
	}
}
