package zsy.hibernate.day34.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day34.domain.Customer;
import zsy.hibernate.day34.util.HibernateUtil;

/**
 * 查询
 * 笛卡尔积:
 */
public class Test4 {


    //  <query name="findAllCustomers"><![CDATA[from Customer]]></query>
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.getNamedQuery("findAllCustomers");
        List<Customer> cs = q.list();
        for (Customer c : cs)
            System.out.println(c);
        tx.commit();
        s.close();
    }

    //左外连接
    @Test
    public void test2() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Customer c left outer join c.orders");
        List<Object[]> list = q.list();//Object[]{Customer,Order}
        for (Object[] objs : list) {
            System.out.println("------------");
            System.out.println(Arrays.toString(objs));
        }
        tx.commit();
        s.close();
    }


    //迫切左外连接:推荐
    //返回左表中所有数据(符合条件的右表数据)
    @Test
    public void test3() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Customer c left outer join fetch c.orders");
        List<Customer> customer = q.list();//有重复
        Set<Customer> set = new HashSet<Customer>(customer);//过滤重复数据
        for (Customer c : set) {
            System.out.println("--------------"+c);
			System.out.println(c.getOrders());
        }
        tx.commit();
        s.close();
    }


}