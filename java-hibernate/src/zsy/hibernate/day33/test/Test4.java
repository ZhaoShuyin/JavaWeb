package cn.itcast.test;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Order;
import cn.itcast.util.HibernateUtil;
//关联检索策略：根据多的一方检索少的一方
public class Test4 {
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Order");
		List<Order> os = q.list();//会加载关联的客户
		for(Order o:os)
			System.out.println(o.getCustomer());
		tx.commit();
		s.close();
		
	}
	//查询OID=1的订单（类级别）
	//把他所属客户也查询出来（关联级别）
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Order o1 = (Order)s.get(Order.class, 1);
		Customer c = o1.getCustomer();
		System.out.println(c);
		
		tx.commit();
		s.close();
		
	}
}
