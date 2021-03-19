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

//丢失更新
public class Test2 {



    /**
     *
     */
    @Test
    public void test10() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c = (Customer) s.get(Customer.class, 1, LockOptions.UPGRADE);//独占锁
        c.setName("bbb");
        tx.commit();
        s.close();
    }

    /**
     * 修改
     */
    @Test
    public void test11() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c = (Customer) s.get(Customer.class, 1, LockOptions.UPGRADE);
        c.setAge(28);
        tx.commit();
        s.close();
    }


    /**
     *
     */
    @Test
    public void test20() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c = (Customer) s.get(Customer.class, 1);
        c.setName("bbb");
        tx.commit();
        s.close();
    }

    /**
     *
     */
    @Test
    public void test21() {
        try {
            Session s = HibernateUtil.openSession();
            Transaction tx = s.beginTransaction();
            Customer c = (Customer) s.get(Customer.class, 1);
            c.setAge(28);
            tx.commit();
            s.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            //提示：请刷新后再试
        }
    }

}
