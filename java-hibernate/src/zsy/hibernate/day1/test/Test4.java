package zsy.hibernate.day1.test;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day1.domain.Customer;
import zsy.hibernate.day1.util.HibernateUtil;
//标准代码:CRUD
public class Test4 {
//	@Test
//	public void testSave(){
//		Customer customer = new Customer();
//		customer.setName("陈涔");
//		Calendar c = Calendar.getInstance();
//		c.set(1993, 1, 18);
//		customer.setBirthday(c.getTime());
//		
//		
//		Session session = null;
//		Transaction tx = null;
//		try {
//			session = HibernateUtil.openSession();
//			tx = session.beginTransaction();
//			session.save(customer);
//			tx.commit();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			if(tx!=null)
//				tx.rollback();
//		}finally{
//			if(session!=null)
//				session.close();
//		}
//	}
	@Test
	public void testFindById(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			Customer c= (Customer)session.get(Customer.class, 1);
					//Class entityClass:实体类型（找打对应的表）
					//Serializable pk:主键
			System.out.println(c);
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
	@Test
	public void testUpdate(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			Customer c= (Customer)session.get(Customer.class, 1);
			c.setBirthday(new Date());
			session.update(c);//暂时真么写（随着不断学习，发现此行代码是多余的）
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
	@Test
	public void testDelete(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			Customer c= (Customer)session.get(Customer.class, 2);//有性能问题（加载策略）
			session.delete(c);
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
	@Test
	public void testFindAll(){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from Customer");//语句不是SQL，而是HQL。面向对象的查询语句。不是表名而是类名
												//不是字段名，而是类的属性。
												//动态查询语句：运行时，hibernate会把HQL翻译成SQL去执行。
			List<Customer> cs = query.list();
			for(Customer c:cs)
				System.out.println(c);
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
