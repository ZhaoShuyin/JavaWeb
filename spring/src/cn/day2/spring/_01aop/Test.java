package cn.day2.spring._01aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day2/spring/_01aop/beans.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) ac.getBean("accountService");
        System.out.println(accountService);
        accountService.transfer();
        accountService.transfer1();
    }

}
