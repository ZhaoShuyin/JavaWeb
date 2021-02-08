package zsy.hibernate.day42.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day42.domain.Customer;
import zsy.hibernate.day42.util.HibernateUtil;

public class Test3 {
    //1级缓存更新会同步2级缓存
    @Test
    public void test2() {
        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        Customer c1 = (Customer) s1.get(Customer.class, 1);
        c1.setAge(38);
        tx1.commit();//会清理：1、同步数据库2、同步二级缓存
        s1.close();//1级缓存关闭了

        Session s2 = HibernateUtil.openSession();
        Transaction tx2 = s2.beginTransaction();
        Customer c2 = (Customer) s2.get(Customer.class, 1);//不会查
        System.out.println(c2);
        tx2.commit();
        s2.close();

    }


}
