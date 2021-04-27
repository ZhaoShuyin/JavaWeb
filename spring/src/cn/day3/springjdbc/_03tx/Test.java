package cn.day3.springjdbc._03tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class Test {

    public static void main(String[] args) {
//		txTest1();
        aopTest();
    }

    private static void txTest1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day3/springjdbc/_03tx/beans1.xml");
        ServiceImpl service = (ServiceImpl) ac.getBean("accountService");
        service.transferTest("aaa", "bbb", 1f);
    }

    /**
     * 必须使用IService接口方式
     */
    private static void aopTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/day3/springjdbc/_03tx/beans2.xml");
        IService service = (IService) ac.getBean("accountService");
        service.transfer("aaa", "bbb", 1f);
//		service.m2();
    }

    private static void propagationTest() {

    }


}
