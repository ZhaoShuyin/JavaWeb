package cn.itcast.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.util.HibernateUtil;
public class Test4 {
	//迫切左外连接:推荐
	@Test
	public void test3(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Customer c left outer join fetch c.orders");
		List<Customer> customer = q.list();//有重复
		Set<Customer> set = new HashSet<Customer>(customer);//过滤重复数据
		for(Customer c:set){
			System.out.println("--------------");
			System.out.println(c);
//			System.out.println(c.getOrders());
		}
			
		tx.commit();
		s.close();
		
	}
	//左外连接
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Customer c left outer join c.orders");
		List<Object[]> list = q.list();//Object[]{Customer,Order}
		for(Object[] objs:list){
			System.out.println("------------");
			for(Object o:objs)
				System.out.println(o);
		}
			
		tx.commit();
		s.close();
		
	}
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.getNamedQuery("findAllCustomers");
		List<Customer> cs = q.list();
		for(Customer c:cs)
			System.out.println(c);
		tx.commit();
		s.close();
		
	}
}
