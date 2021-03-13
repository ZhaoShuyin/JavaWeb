package zsy.hibernate.day20.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day1.domain.Customer;
import zsy.hibernate.day20.util.HibernateUtil;

/**
 * Hibernate一级缓存测试
 */
public class Test2 {

    //flush();//手动清理
    @Test
    public void test1() {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        //查询
        Customer c1 = (Customer) session.get(Customer.class, 1);
        c1.setName("陈涔12111456789");
        //从缓存中刷新数据
        session.flush();           //1:清理缓存, 2:同步数据库(执行SQL)
//        session.clear();         //清空缓存不同步到数据库
        //提交
        tx.commit();         //不清理
        session.close();
    }

    //clear();//清空一级缓存
    @Test
    public void test2() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);//查
        s.clear();
        Customer c2 = (Customer) s.get(Customer.class, 1);//查
        tx.commit();
        s.close();
    }

    //evict(Object entity);
    //从一级缓存清除指定的实体对象(重新查询)
    @Test
    public void test3() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);//查
        Customer c2 = (Customer) s.get(Customer.class, 2);//查
        s.evict(c1);
        Customer c11 = (Customer) s.get(Customer.class, 1);//查
        Customer c22 = (Customer) s.get(Customer.class, 2);//不查
        tx.commit();
        s.close();
    }

    //refresh(Object entity);
    //从数据库中重新读取数据覆盖缓存中的数据
    @Test
    public void test4() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);//查：陈涔1
        c1.setName("陈涔111");//内存发生了变化
        s.refresh(c1);       //重新从数据库查询：陈涔1
        tx.commit();
        s.close();
    }

    //执行Query查询（动态查询）时，也会自动刷新，目的就是为了获取到的数据是正确的
    @Test
    public void test5() {
        Session s = HibernateUtil.openSession();
//		s.setFlushMode(FlushMode.COMMIT);
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);//查：陈涔1
        String value = String.valueOf(System.currentTimeMillis());
        System.out.println("设置为 -> " + value);
        c1.setName(value);//内存发生了变化
        Query q = s.createQuery("from Customer");//应该获取陈涔111.会自动清理
        List<Customer> list = q.list();
        for (Customer customer : list) {
            if (customer.getName().equals(value)) {
                System.out.println("=================== 这个是刚才修改的");
            } else {
                System.out.println("===================");
            }
            System.out.println(customer);
        }
        tx.commit();
        s.close();
    }

    //save和persist的区别
    @Test
    public void test6() {
        Customer c = new Customer();
        c.setName("杜巍锋");
        c.setBirthday(new Date());
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(c);
        tx.commit();
        session.close();
    }


}
