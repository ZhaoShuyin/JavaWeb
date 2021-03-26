package zsy.hibernate.day33.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day33.domain.Customer;
import zsy.hibernate.day33.domain.Order;
import zsy.hibernate.day33.util.HibernateUtil;

public class Test1 {

    /**
     * 懒加载查询
     */
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);
        System.out.println("======= 先查询到用户信息" + c1);
        System.out.println("======= 根据需要再查询关联订单");
       /* Set<Order> orders = c1.getOrders();
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            Order next = iterator.next();
            System.out.println("=======" + next);
        }*/
       /* for (Order order : orders) {
            System.out.println("=======" + order);       //导航查询
        }*/
        tx.commit();
        s.close();
    }

    /**
     * 延时查询
     */
    @Test
    public void test2() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Customer");
        List<Customer> customers = q.list();
        for (Customer c : customers) {
            System.out.println(c);
            for (Order order : c.getOrders()) {
                System.out.println(order);//导航查询
            }
        }
        tx.commit();
        s.close();
    }


}
