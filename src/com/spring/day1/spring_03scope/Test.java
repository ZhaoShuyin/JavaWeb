package com.spring.day1.spring_03scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * scope : 作用域/范围
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_03scope/beans.xml");
        UserDao userDao1 = (UserDao) ac.getBean("userDao");
        UserDao userDao2 = (UserDao) ac.getBean("userDao");
        System.out.println(userDao1 == userDao2);//true
        System.out.println(userDao1);
        System.out.println(userDao2);
        userDao1.save();

        System.out.println("======================================");
        ((UserDao) ac.getBean("userDaoMultiple")).save();
        ((UserDao) ac.getBean("userDaoMultiple")).save();

    }
}
