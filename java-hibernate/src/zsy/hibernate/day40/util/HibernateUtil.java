package zsy.hibernate.day40.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //创建一个SessionFactory
    private static final SessionFactory sessionFactory;//唯一

    //初始化
    static {
        sessionFactory = new Configuration()
                .configure("zsy/hibernate/day40/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();//开启新的Session：手工
    }

    /**
     * 从当前线程上获取
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void main(String[] args) {
        Session s = openSession();//初始化一次，产生表结构
        s.close();
    }
}
