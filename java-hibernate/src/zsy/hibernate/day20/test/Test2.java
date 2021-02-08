package cn.itcast.test;

import java.util.Date;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.util.HibernateUtil;
public class Test2 {
	//save和persist的区别
	@Test
	public void test6(){
		Customer c = new Customer();
		c.setName("杜巍锋");
		c.setBirthday(new Date());
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(c);
		tx.commit();
		s.close();
	}
	
	
	//执行Query查询（动态查询）时，也会自动刷新，目的就是为了获取到的数据是正确的
	@Test
	public void test5(){
		Session s = HibernateUtil.openSession();
//		s.setFlushMode(FlushMode.COMMIT);
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer)s.get(Customer.class, 1);//查：陈涔1
		c1.setName("陈涔111");//内存发生了变化
		Query q = s.createQuery("from Customer");//应该获取陈涔111.会自动清理
		List list = q.list();
		System.out.println(list);
		tx.commit();
		s.close();
	}
	
	//refresh(Object entity);//从数据库中重新读取数据覆盖缓存中的数据
	@Test
	public void test4(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer)s.get(Customer.class, 1);//查：陈涔1
		c1.setName("陈涔111");//内存发生了变化
		s.refresh(c1);//重新从数据库查询：陈涔1
		tx.commit();
		s.close();
	}
	//evict(Object entity);//从一级缓存清除指定的实体对象
	@Test
	public void test3(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer)s.get(Customer.class, 1);//查
		Customer c2 = (Customer)s.get(Customer.class, 2);//查
		s.evict(c1);
		Customer c11 = (Customer)s.get(Customer.class, 1);//查
		Customer c22 = (Customer)s.get(Customer.class, 2);//不查
		
		
		tx.commit();
		s.close();
	}
	
	//clear();//清空一级缓存
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer)s.get(Customer.class, 1);//查
		s.clear();
		Customer c2 = (Customer)s.get(Customer.class, 1);//查
		tx.commit();
		s.close();
	}
	//flush();//手动清理
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer)s.get(Customer.class, 1);
		c1.setName("陈涔11");
		s.flush();//清理：同步数据库
		tx.commit();//不清理
		s.close();
	}
}
