package zsy.hibernate.day20.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day20.domain.Customer;
import zsy.hibernate.day20.util.HibernateUtil;

/**
 * Session对象状态
 * 1:	临时状态                刚创建时
 * 2:	持久化状态              save();
 * 3:	删除状态(removed)
 * 4:	游离状态(detached脱管)  close();
 */
public class Test3 {

    // select-before-update="true"
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);//持久态
        System.out.println(" 查询 " + c1);
        tx.commit();
        s.close();              //c1变为了：游离态

        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        s1.update(c1);          //实体对象数据没有变化(但是也更新)
        System.out.println(" 更新 " + c1);
        tx1.commit();
        s1.close();
    }

    //update一个游离对象时，如果已经存在OID相同的持久态对象，则报错
    @Test
    public void test2() {
        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        Customer c1 = (Customer) s1.get(Customer.class, 1);//持久态
        tx1.commit();
        s1.close();     //c1变为了：游离态

        Session s2 = HibernateUtil.openSession();
        Transaction tx2 = s2.beginTransaction();
        Customer c2 = (Customer) s2.get(Customer.class, 1);//持久态
        s2.update(c1);//出问题
        tx2.commit();
        s2.close();
    }

    //
    @Test
    public void test3() {
        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        Customer c1 = (Customer) s1.get(Customer.class, 1);//持久态
        tx1.commit();
        s1.close();
        //c1游离
        Session s2 = HibernateUtil.openSession();
        Transaction tx2 = s2.beginTransaction();
        s2.saveOrUpdate(c1);
        tx2.commit();
        s2.close();
    }

    //<id name="id" column="ID" unsaved-value="100">
    //如果一个游离态对象的id=100，请当做临时态
    @Test
    public void test4() {
        Customer c = new Customer();
        c.setId(8);
        c.setName("何亮亮");
        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        s1.saveOrUpdate(c);
        tx1.commit();
        s1.close();
    }

    //merge:合并数据
    @Test
    public void test5() {
        Session s1 = HibernateUtil.openSession();
        Transaction tx1 = s1.beginTransaction();
        Customer c1 = (Customer) s1.get(Customer.class, 1);//持久态
        tx1.commit();
        s1.close();    //c1变为了：游离态

        Session s2 = HibernateUtil.openSession();
        Transaction tx2 = s2.beginTransaction();
        Customer c2 = (Customer) s2.get(Customer.class, 1);//持久态
        Customer c3 = (Customer) s2.merge(c1);    //把c1的数据拷贝到c3对象中
        System.out.println("(c2 == c3) ==> " + (c2 == c3));

        tx2.commit();
        s2.close();
    }


}
