package com.zsy.ssh.test;

import com.zsy.ssh.service.TestService;
import com.zsy.ssh.transaction.MyEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Title com.zsy.ssh.test
 * @date 2021/4/26
 * @autor Zsy
 */

public class Test {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Object testService = ac.getBean("testService");*/
        test2();
    }

    private static void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/zsy/ssh/test/bean33.xml");
        TestService service = (TestService) ac.getBean("xxxService");

        ((ClassPathXmlApplicationContext) ac).addApplicationListener(new ApplicationListener(){
            @Override
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                System.out.println("applicationEvent ====== "+applicationEvent);
            }
        });
        MyEvent event = new MyEvent("test", service);
        ac.publishEvent(event);

        service.saveTest();
    }

    private static void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/zsy/ssh/test/beantx.xml");
        TestService service = (TestService) ac.getBean("xxxService");

        TransactionSynchronizationManager.initSynchronization();
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCompletion(int status) {
                super.afterCompletion(status);
                System.out.println("status:" + status);
            }

            @Override
            public void beforeCommit(boolean readOnly) {
                super.beforeCommit(readOnly);
                System.out.println("readOnly:" + readOnly);
            }

            @Override
            public void beforeCompletion() {
                super.beforeCompletion();
            }
        });

        System.out.println("==================== 添加");
        try {
            service.saveTest();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=============== "+e.toString());
        }

        System.out.println("==================== 转");
        try {
            service.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=============== "+e.toString());
        }

        System.out.println("==================== 添加");
        try {
            service.saveTest();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=============== "+e.toString());
        }


    }

}
