package com.spring.day1.spring_01IoC;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * IOC :Inverse Of Control
 * 控制反转 : 使用ApplicationContext把创建对象的过程交由Spring控制
 */
public class Test {

    /**
     * 通过ApplicationContext和xml配置文件实现AOP的自动创建
     *
     * @param args
     */
    public static void main(String[] args) {
        //ApplicationContext:非常重要的接口，用来操作Spring容器
        //ClassPathXmlApplicationContext:配置文件是在classpath中的

        //初始化Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/day1/spring_01IoC/beans.xml");
        //从spring容器中根据bean的名称获取对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.regist();

		Resource resource = new ClassPathResource("spring/day1/spring_01IoC/beans.xml");
//        Resource:把配置文件看做资源，可以使用通配符
		BeanFactory bf = new XmlBeanFactory(resource);
//        从spring容器中根据bean的名称获取对象
		UserService uService = (UserService)bf.getBean("userService");
        uService.regist();
    }
}
