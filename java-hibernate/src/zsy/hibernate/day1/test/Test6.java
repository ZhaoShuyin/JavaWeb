package zsy.hibernate.day1.test;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day1.domain.Person;
import zsy.hibernate.day1.domain.Student;
import zsy.hibernate.day1.util.HibernateUtil;
public class Test6 {
	@Test
	public void testSave(){
		Person p = new Person();
		p.setName("杜巍锋");
		p.setIdcard("1111111");
		Calendar c = Calendar.getInstance();
		c.set(1999, 1, 10);
		p.setRegistDate(c.getTime());
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();//提交事务
		session.close();//释放资源
	}
	@Test
	public void testUpdate(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Person p = (Person) session.get(Person.class, 2);
		p.setIdcard("222222XXX");
		session.update(p);
		tx.commit();//提交事务
		session.close();//释放资源
	}
}
