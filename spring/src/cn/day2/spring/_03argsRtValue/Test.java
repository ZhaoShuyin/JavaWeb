package cn.day2.spring._03argsRtValue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试 返回值 / rollback
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day2/spring/_03argsRtValue/beans.xml");
        ServiceImpl accountService = (ServiceImpl) ac.getBean("accountService");
//		accountService.transfer("abc");
//        accountService.transfer1();


        String login = accountService.login();
        System.out.println("service return : "+login);
    }

}
