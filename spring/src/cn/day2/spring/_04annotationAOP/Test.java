package cn.day2.spring._04annotationAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试 注解 AOP
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(
                        "cn/day2/spring/_04annotationAOP/beans.xml");

        System.out.println("================================================");

        //获取使用@Component("accountService")的类
        ServiceImpl accountService = (ServiceImpl) ac.getBean("accountService");
        accountService.transfer();

        System.out.println("================================================");

//        Service service = (Service)ac.getBean("service");
//        service.transfer();

        System.out.println("================================================");
    }

}
