package zsy.hibernate.day1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate 的 SessionFactory 单例模式
 */
public class HibernateUtil {
    //创建一个SessionFactory
    private static final SessionFactory sessionFactory;//唯一静态对象

    //初始化(静态代码块进行初始化)(加载类时执行)
    static {
        sessionFactory = new Configuration()
                .configure("zsy/hibernate/day1/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
