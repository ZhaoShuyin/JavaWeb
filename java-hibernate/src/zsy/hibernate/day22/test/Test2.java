package zsy.hibernate.day22.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day22.domain.Customer;
import zsy.hibernate.day22.domain.Order;
import zsy.hibernate.day22.util.HibernateUtil;

public class Test2 {

    //解除关系，并不指定新关系
    /*
     *一对多中还有一种：父子概念
     *		没有主（父）记录就不会有从（子）记录
     *		一对多中存在主从概念的，但不一定存在父子概念。
     *		比如：部门和员工：主从，但没有父子概念
     *			  客户和订单：主从，但有父子概念（解除关系时，把子记录删除（孤儿））
     *				<set name="orders" inverse="true" cascade="delete-orphan">
     */
    @Test
    public void test2() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c2 = (Customer) s.get(Customer.class, 2);
        Order o3 = (Order) s.get(Order.class, 4);
        c2.getOrders().remove(o3);
        o3.setCustomer(null);

        tx.commit();
        s.close();

    }

    //删除：少的一方
    // 一对多：主从概念
    //级联删除：删除自己的同时，会把关联的实体也删除
    //Customer.hbm.xml:<set name="orders" inverse="true" cascade="delete">
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);
        s.delete(c1);//默认情况下，不允许删除的。被关联着
        tx.commit();
        s.close();

    }

    @Test
    public void query(){
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Object o = s.get(Customer.class, 1);
        tx.commit();
        s.close();
    }

}
