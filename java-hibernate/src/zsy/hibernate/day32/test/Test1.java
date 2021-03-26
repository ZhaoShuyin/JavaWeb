package zsy.hibernate.day32.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

import zsy.hibernate.day32.domain.Employee;
import zsy.hibernate.day32.domain.HourlyEmployee;
import zsy.hibernate.day32.domain.SalaryEmployee;
import zsy.hibernate.day32.util.HibernateUtil;

/**
 * 继承关系映射
 */
public class Test1 {


    @Test
    public void insert() {
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
    @Test
	public void query() {
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();

//		Employee e1 = (Employee)s.get(Employee.class, 1);
//		Employee e2 = (Employee)s.get(Employee.class, 2);
//
//		System.out.println(e1);
//		System.out.println(e2);

//		Query q = s.createQuery("from java.lang.Object");//3个：多态查询
		Query q = s.createQuery("from Employee");            //3个：多态查询
        List list = q.list();
        for (Object employee:list) {
            System.out.println(employee);
        }
		tx.commit();
		s.close();
	}
}
