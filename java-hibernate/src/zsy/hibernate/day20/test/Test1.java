package zsy.hibernate.day20.test;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import zsy.hibernate.day1.domain.Customer;
import zsy.hibernate.day20.util.HibernateUtil;

/**
 * Hibernate缓存测试
 */
public class Test1 {


    //验证一级缓存的存在
    //重复查询使用缓存
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);//查询对象：会加入到Session的一级缓存
        Customer c2 = (Customer) s.get(Customer.class, 1);//不会去数据库查询，缓存中有了
        System.out.println(c1 == c2);//true
        tx.commit();
        s.close();
    }

    //一级缓存中对象的变化，会自动同步到数据库中
    //缓存中数据自动更新同步到数据库
    @Test
    public void test2() {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Customer c1 = (Customer) session.get(Customer.class, 1);//查询对象：会加入到Session的一级缓存
        System.out.println(c1);
        c1.setName("陈涔123");
        transaction.commit();//默认时，此时进行同步（把内存---->数据库中）
        session.close();
    }

    //多次更新，会合并同步，减少与数据库的交互次数。  同步时机
    @Test
    public void test3() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Customer c1 = (Customer) s.get(Customer.class, 1);//查询对象：会加入到Session的一级缓存
        System.out.println(c1);//陈涔
        c1.setName("陈涔1");
        c1.setName("陈涔2");
        tx.commit();                                               //默认时，此时进行同步（把内存---->数据库中）
        s.close();
    }


    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setName("陈涔");
        Calendar c = Calendar.getInstance();
        c.set(1993, 1, 18);
        customer.setBirthday(c.getTime());

        //加载hibernate.cfg.xml配置文件
        Configuration cfg = new Configuration();//加载类路径中的hibernate.properties配置文件
        cfg.configure();                        //加载类路径中的hibernate.cfg.xml配置文件
        //得到SessionFactory实例
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //获取Session:hibernate的一切操作都是基于Session对象
        Session session = sessionFactory.openSession();
        //开启事务：
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();                              //提交事务
        session.close();                          //释放资源
        sessionFactory.close();                   //暂时关闭
    }
}
