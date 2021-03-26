package zsy.hibernate.day42.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day42.domain.Customer;
import zsy.hibernate.day42.util.HibernateUtil;

/**
 * 验证二级缓存开启成功
 */
public class Test1 {

    @Test
    public void test1() {
        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        Customer c1 = (Customer) s1.get(Customer.class, 1);//get:能操作一级缓存，也能操作二级缓存
        //放入Session1的一级缓存，同时放入二级缓存
        //此时是第一次查询：会执行select语句
        System.out.println("第一次查询 : " + c1);
        tx1.commit();
        s1.close();//一级缓存关闭了

        Session s2 = HibernateUtil.openSession();
        Transaction tx2 = s2.beginTransaction();
        Customer c2 = (Customer) s2.get(Customer.class, 1);//如果二级缓存有效，不会查询的。直接从二级缓存取
        System.out.println("第二次查询 : " + c2);
        tx2.commit();
        s2.close();//一级缓存关闭了

        System.out.println("c1 " + System.identityHashCode(c1));
        System.out.println("c2 " + System.identityHashCode(c2));

        System.out.println("equals ; " + c1.equals(c2));//equals方法就是比较对象的内存地址。String：该类覆盖了equals方法而已
        System.out.println("c1 == c2 : " + (c1 == c2));//不是同一个对象

    }


    /**
     * Query只能存，但不能取二级缓存中的数据
     */
    @Test
    public void test2() {
        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        Query q1 = s1.createQuery("from Customer c where c.id=1");
        Customer c1 = (Customer) q1.uniqueResult();//会查询，也会把数据存到1和2级缓存中
        System.out.println("c1:" + c1);
        tx1.commit();
        s1.close();//1级缓存关闭了

        Session s2 = HibernateUtil.openSession();
        Transaction tx2 = s2.beginTransaction();
        Query q2 = s2.createQuery("from Customer c where c.id=1");
        Customer c21 = (Customer) s2.get(Customer.class, 1);//可以从二级缓存中取,不会查询。
        Customer c22 = (Customer) q2.uniqueResult();                  //无法从二级缓存中取数据,会查询。
        System.out.println("c21:" + c21);
        System.out.println("c22:" + c22);
        tx2.commit();
        s2.close();

    }


}
