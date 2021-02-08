package cn.itcast.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.domain.Employee;
import cn.itcast.domain.HourlyEmployee;
import cn.itcast.domain.SalaryEmployee;
import cn.itcast.util.HibernateUtil;

public class Test {
//	单表操作
	public static void main(String[] args) {
		Employee ee = new Employee();
		ee.setName("陈涔");
		
		HourlyEmployee he = new HourlyEmployee();
		he.setName("杜巍锋");
		he.setRate(100f);
		
		SalaryEmployee se = new SalaryEmployee();
		se.setName("何亮");
		se.setSalary(10000f);
		
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(ee);
		s.save(he);
		s.save(se);
		
		tx.commit();
		s.close();
	}
	//多态查询
//	public static void main(String[] args) {
//		Session s = HibernateUtil.openSession();
//		Transaction tx = s.beginTransaction();
//		
////		Employee e1 = (Employee)s.get(Employee.class, 1);
////		Employee e2 = (Employee)s.get(Employee.class, 2);
////		
////		System.out.println(e1);
////		System.out.println(e2);
//		
////		Query q = s.createQuery("from java.lang.Object");//3个：多态查询
//		Query q = s.createQuery("from Employee");//3个：多态查询
//		System.out.println(q.list());
//		
//		tx.commit();
//		s.close();
//	}
}
