package spring.day1.spring_02init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    /**
     * 封装工厂类来获取实现对象实例
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/day1/spring_02init/beans.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao2");
        userDao.save();
        UserDao userDa = (UserDao) ac.getBean("userDao2");
        userDa.save();

        UserDao userD = (UserDao) ac.getBean("userDao1");
        userD.save();

        UserDao userD2 = (UserDao) ac.getBean("userDao1");
        userD2.save();
    }

}
