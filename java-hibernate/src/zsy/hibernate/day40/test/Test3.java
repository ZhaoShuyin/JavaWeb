package zsy.hibernate.day40.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day40.domain.Customer;
import zsy.hibernate.day40.util.HibernateUtil;

public class Test3 {
    @Test
    public void test10() {
        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();
        Customer c = (Customer) s.get(Customer.class, 1);
        c.setName("bbb");
        tx.commit();
//		s.close();//不要自己关闭，由hibernate根据线程自动关闭
    }
}
