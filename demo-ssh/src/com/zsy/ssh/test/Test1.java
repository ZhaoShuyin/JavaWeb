package com.zsy.ssh.test;

import com.zsy.ssh.service.TestService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义事务管理器测试
 */
public class Test1 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/zsy/ssh/test/bean1.xml");
        TestService service = (TestService) ac.getBean("xxxService");
        service.saveTest();
    }

}
