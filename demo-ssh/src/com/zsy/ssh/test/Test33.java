package com.zsy.ssh.test;

import com.zsy.ssh.service.IService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用
 * org.springframework.jdbc.datasource.DataSourceTransactionManager
 * org.springframework.jdbc.core.JdbcTemplate
 * 进行事务测试
 */
public class Test33 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/zsy/ssh/test/bean33.xml");
        IService service = (IService) ac.getBean("xxxService");
        service.saveTest();
    }

}
