package cn.day3.springjdbc._04txAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day3/springjdbc/_04txAnnotation/beans.xml");

        //@Service("accountService") 使用注解

        IService s = (IService) ac.getBean("accountService");

        System.out.println("Class >> " + s.getClass().getName());
        boolean transfer = s.transfer("aaa", "bbb", 1f);
        System.out.println("transfer: " + transfer);
    }

}
