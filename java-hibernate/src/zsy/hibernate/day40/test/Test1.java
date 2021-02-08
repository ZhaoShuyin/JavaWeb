package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.util.HibernateUtil;
public class Test1 {
	@Test
	public void save(){
		
		Customer customer = new Customer();
		customer.setName("aaa");
		customer.setAge(18);
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		s.save(customer);
		tx.commit();
		s.close();
		
	}
}
