package zsy.hibernate.day33.test;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day33.domain.Customer;
import zsy.hibernate.day33.domain.Order;
import zsy.hibernate.day33.util.HibernateUtil;

/**
 * 类级别的检索策略
 */
public class Test2 {

    /**
     * .load() 先不查询先使用代理对象
     */
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        //select * from CUSTOMERS where id=? //把客户的所有信息都查询出来

//		Customer c1 = (Customer) s.get(Customer.class, 1);//立即检索
//		System.out.println(c1);

        //延迟加载:不会去查,真正用时才会去查
        //返回的是Customer的代理对象，该对象只有一个属性，id属性
        Customer c1 = (Customer) s.load(Customer.class, 1);
        System.out.println(c1.getId());
        System.out.println("===========");
        System.out.println(c1.getName());
        System.out.println("===========");
        System.out.println(c1.getOrders());
        tx.commit();
        s.close();
    }


    @Test
    //因为用的是延迟加载，真正用到数据时，要去数据库查询，但此时Session已经关闭了
    //org.hibernate.LazyInitializationException: could not initialize proxy - no Session
    public void test2() {
        Customer c = findCustomerById(1);
        System.out.println(c.getName());
        System.out.println(c.getOrders());
    }

    public static Customer findCustomerById(Integer customerId) {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.load(Customer.class, customerId);//立即检索
        System.out.println("目前还未查询");
        Hibernate.initialize(c1);      //初始化代理对象：原来只有OID，初始化后所有数据都有了
        System.out.println("执行initialize 查询");
        tx.commit();
        s.close();
        return c1;
    }


    //目前id=3的订单时2号客户的
    //id=3的订单给id=1的客户
    @Test
    public void test3() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Order o3 = (Order) s.get(Order.class, 2);
        Customer c1 = (Customer) s.get(Customer.class, 2);

//        c1.getOrders().add(o3);   // 无效的
        o3.setCustomer(c1);         // 有效的

        tx.commit();
        s.close();
    }


    //查询所有客户
    @Test
    public void test4() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Customer");//准备语句

        List<Customer> cs = q.list();              //此时加载(执行查询)
        for (int i = 0; i < cs.size(); i++) {
            System.out.println(cs.get(i));
        }
        tx.commit();
        s.close();
    }


}