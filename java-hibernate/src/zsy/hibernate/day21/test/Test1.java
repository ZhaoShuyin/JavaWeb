package zsy.hibernate.day21.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day21.domain.Customer;
import zsy.hibernate.day21.domain.Order;
import zsy.hibernate.day21.util.HibernateUtil;

/**
 * 重点  cascade="save-update" 关联同步
 * 多对一 关联关系
 */
public class Test1 {

    //先保存订单，再保存客户
    @Test
    public void test1() {
        Customer c = new Customer();
        c.setName("用户3+5");

        Order o1 = new Order();
        o1.setMoney(3003f);
        Order o2 = new Order();
        o2.setMoney(3003f);

        //建立关联关系：单向多对一。通过订单设置客户
        o1.setCustomer(c);
        o2.setCustomer(c);

        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();

        s.save(o1);//insert into orders (money,customer_id) values (1000,null);
        s.save(o2);//insert into orders (money,customer_id) values (200,null);
        s.save(c);//insert customers (name) values ("dwf");

        tx.commit();//2次update。update orders set customer_id=1 where ....
        s.close();
    }


    //先保存客户，再保存订单
    @Test
    public void test2() {
        Customer c = new Customer();
        c.setName("客户11");

        Order o1 = new Order();
        o1.setMoney(4004f);
        Order o2 = new Order();
        o2.setMoney(4004f);

        //建立关联关系：单向多对一。通过订单设置客户
        o1.setCustomer(c);
        o2.setCustomer(c);

        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();

        s.save(c);//insert customers (name) values ("dwf");
        s.save(o1);//insert into orders (money,customer_id) values (1000,1);
        s.save(o2);//insert into orders (money,customer_id) values (200,1);

        tx.commit();
        s.close();
    }


    //不保存客户，再保存订单
    //报错：定单是持久态；客户是临时态
    //在保存持久态对象时，如果其还关联着一个临时态对象，则报错。（持久态不能关联临时态）

    //解决以上问题办法：
    //把customer变为持久态
    //级联保存：持久态关联临时态对象时，自动把临时态转为持久态
    //cascade:save-update级联保存和更新
    @Test
    public void test3() {
        Customer c = new Customer();
        c.setName("5005");
        Order o1 = new Order();
        o1.setMoney(5005f);
        Order o2 = new Order();
        o2.setMoney(5005f);
        //建立关联关系：单向多对一。通过订单设置客户
        o1.setCustomer(c);
        o2.setCustomer(c);

        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
//		s.save(c);//insert customers (name) values ("dwf");
        s.save(o1);//insert into orders (money,customer_id) values (1000,1);
        s.save(o2);//insert into orders (money,customer_id) values (200,1);

        tx.commit();
        s.close();
    }


}