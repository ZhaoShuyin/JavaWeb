package cn.day1.spring_04lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 容器周期测试
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("cn/day1/spring_04lifecycle/beans.xml");
        IUser user1 = (IUser) ac.getBean("user");
        System.out.println("user1: "+user1);
        IUser user2 = (IUser) ac.getBean("user");
        System.out.println("user2: "+user2);
        ac.close();
    }
}
