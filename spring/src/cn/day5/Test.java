package cn.day5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.ContextLoaderListener;

/**
 * @Title cn.day4.S2S3H3_03
 * @date 2021/4/22
 * @autor Zsy
 */

public class Test {
    ContextLoaderListener loaderListener;

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day5/beans.xml");



    }
}
