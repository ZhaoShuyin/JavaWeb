package cn.day2.spring._04annotationAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(
                        "cn/day2/spring/_04annotationAOP/beans.xml");
        //获取使用@Component("accountService")的类
        ServiceImpl accountService = (ServiceImpl) ac.getBean("accountService");
        accountService.transfer();
        System.out.println("========================");
        Service service = (Service)ac.getBean("service");
        service.transfer();
    }

}
