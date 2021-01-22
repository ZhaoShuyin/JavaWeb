package cn.day1.spring_03scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("cn/day1/spring_03scope/beans.xml");
        IUser user1 = (IUser) ac.getBean("user");
        System.out.println("user1: " + user1);
        IUser user2 = (IUser) ac.getBean("user");
        System.out.println("user2: " + user2);
        System.out.println("user1 == user2 : " + (user1 == user2));//true
    }
}
