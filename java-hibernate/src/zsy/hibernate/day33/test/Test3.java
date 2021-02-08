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
//关联检索策略：根据少的一方检索多的一方
public class Test3 {
	//查询1号客户订单的数量
	@Test
	public void test3(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer)s.get(Customer.class, 1);
		System.out.println(c1);
		System.out.println(c1.getOrders().size());//延迟加载；产生一条新的SQL语句
		System.out.println(c1.getOrders());
		tx.commit();
		s.close();
		
	}
	
	//查询所有客户：用默认值lazy=true fetch=select 存在N+1次查询
	//可以设置批量检索的数量：<set name="orders" inverse="true" batch-size="3">
		//批量检索的数值：3~10
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Customer");//类级别
		List<Customer> cs = q.list();//真正查询客户
		for(Customer c:cs)
			System.out.println(c.getOrders());//关联级别
		tx.commit();
		s.close();
		
	}
	
	//查询OID=1的客户（类级别）
	//把他的订单也查询出来（关联级别）
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c1 = (Customer)s.get(Customer.class, 1);
		System.out.println(c1);
		System.out.println(c1.getOrders());//延迟加载；产生一条新的SQL语句
		
		tx.commit();
		s.close();
		
	}
}
