package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.util.HibernateUtil;
//各种查询：原生SQL
public class Test3 {
	//使用原生SQL,让Hibernate把结果封装到实体中
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		SQLQuery query = s.createSQLQuery("select * from customers").addEntity(Customer.class);//SQL
		List<Customer> list = query.list();
		for(Customer c:list){
			System.out.println(c);
		}
			
		tx.commit();
		s.close();
		
	}
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		SQLQuery query = s.createSQLQuery("select * from customers");//SQL
//		query.setInteger(0, 1);
		List<Object[]> list = query.list();//返回的并不是实体对象
										//Object[]数组:数组的元素为每条记录的列值
											//每一个数组：Object[]{1,"客户1"}
		for(Object[] objs:list){
			System.out.println("-------------");
			for(Object obj:objs)
				System.out.println(obj);
		}
			
		tx.commit();
		s.close();
		
	}
}
