package zsy.hibernate.day33.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day33.domain.Customer;
import zsy.hibernate.day33.domain.Order;
import zsy.hibernate.day33.util.HibernateUtil;
public class Test1 {
	@Test
	public void test2(){
		
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Customer");
		List<Customer> customers = q.list();
		for(Customer c:customers){
			System.out.println(c);
			System.out.println(c.getOrders());
		}
		tx.commit();
		s.close();
		
	}
	@Test
	public void test1(){
		
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer) s.get(Customer.class, 1);
		System.out.println(c1);
		System.out.println(c1.getOrders());//导航查询
		tx.commit();
		s.close();
		
	}
}
