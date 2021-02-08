package zsy.hibernate.day1.test;

import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day1.domain.Customer;
import zsy.hibernate.day1.util.HibernateUtil;
//标准代码
public class Test3 {
	@Test
	public void testSave(){
		Customer customer = new Customer();
		customer.setName("陈涔");
		Calendar c = Calendar.getInstance();
		c.set(1993, 1, 18);
		customer.setBirthday(c.getTime());
		
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
	}
}
