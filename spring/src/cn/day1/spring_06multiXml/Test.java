package cn.day1.spring_06multiXml;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * import xml文件
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext(
                        "cn/day1/spring_06multiXml/beans.xml"
                );
        Bean1 bean1 = (Bean1) ac.getBean("bean2");
        System.out.println(bean1);
    }
}
