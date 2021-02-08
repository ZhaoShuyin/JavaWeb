package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.util.HibernateUtil;
public class Test4 {
	@Test
	public void test2(){
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		Query q1 = s1.createQuery("from Customer c where c.id=1");
		q1.setCacheable(true);//才使用查询缓存区
		Customer c1 = (Customer) q1.uniqueResult();//会查询，也会把数据存到1和2级缓存中(的查询缓存区)
		System.out.println("c1:"+c1);
		tx1.commit();
		s1.close();//1级缓存关闭了
		
		Session s2 = HibernateUtil.openSession();
		Transaction tx2 = s2.beginTransaction();
		Query q2 = s2.createQuery("from Customer c where c.id=1");
		q2.setCacheable(true);
		Customer c21 = (Customer) s2.get(Customer.class, 1);//可以从二级缓存中取。不会查询
		Customer c22 = (Customer) q2.uniqueResult();//不会查询，Query从二级缓存中（查询缓存区）取数据
		System.out.println("c21:"+c21);
		System.out.println("c22:"+c22);
		tx2.commit();
		s2.close();
		
	}
}
