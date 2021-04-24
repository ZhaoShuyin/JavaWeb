package cn.day2.spring._01aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP 代理测试
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day2/spring/_01aop/beans.xml");
        ServiceImpl accountService = (ServiceImpl) ac.getBean("service");
        System.out.println(accountService);
        //执行一个方法
        accountService.transfer();
        //执行一个方法
        accountService.transfer1();
    }

}
