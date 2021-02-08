package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Order;
import cn.itcast.util.HibernateUtil;
public class Test1 {
	//id=3的订单给id=1的客户
	/*
	 * 清理时：（重复）
	 *  Hibernate: update ORDERS set MONEY=?, CUSTOMER_ID=? where ID=?//给id=3的订单指定客户的id=1
		Hibernate: update ORDERS set CUSTOMER_ID=? where ID=?//更改id=3的订单的客户id=1
	 */
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer) s.get(Customer.class, 1);
		Order o3 = (Order)s.get(Order.class, 3);
		
		c1.getOrders().add(o3);
		o3.setCustomer(c1);//双向建立关联关系
		
		tx.commit();//清理
		s.close();
		
	}
	//先保存客户,再保存订单.双向建立了关联关系
	/*
	 * Hibernate: insert into CUSTOMERS (NAME) values (?)
		Hibernate: insert into ORDERS (MONEY, CUSTOMER_ID) values (?, ?)
		Hibernate: insert into ORDERS (MONEY, CUSTOMER_ID) values (?, ?)
		Hibernate: update ORDERS set CUSTOMER_ID=? where ID=?
		Hibernate: update ORDERS set CUSTOMER_ID=? where ID=?
	 */
	//先保存订单,再保存客户.双向建立了关联关系
	/*
	 *  Hibernate: insert into ORDERS (MONEY, CUSTOMER_ID) values (?, ?)//插入1号订单，没有客户
		Hibernate: insert into ORDERS (MONEY, CUSTOMER_ID) values (?, ?)//插入2号订单，没有客户
		Hibernate: insert into CUSTOMERS (NAME) values (?)//插入客户信息
		Hibernate: update ORDERS set MONEY=?, CUSTOMER_ID=? where ID=?//更新1号订单的客户为1号客户
		Hibernate: update ORDERS set MONEY=?, CUSTOMER_ID=? where ID=?//更新2号订单的客户为1号客户
		Hibernate: update ORDERS set CUSTOMER_ID=? where ID=?//更新1号订单的客户为1号客户(重复)
		Hibernate: update ORDERS set CUSTOMER_ID=? where ID=?//更新2号订单的客户为1号客户(重复)
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setName("杜巍锋");
		
		Order o1 = new Order();
		o1.setMoney(1000f);
		
		Order o2 = new Order();
		o2.setMoney(200f);
		//订单关联客户
		o1.setCustomer(c);
		o2.setCustomer(c);
		//客户关联订单
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		
		
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(c);
//		s.save(o1);
//		s.save(o2);
		
		
		tx.commit();
		s.close();
		
	}
}
