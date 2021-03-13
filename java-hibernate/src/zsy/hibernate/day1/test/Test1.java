package zsy.hibernate.day1.test;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import zsy.hibernate.day1.domain.Customer;

/**
 * 入门案例
 */
public class Test1 {
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setName("名称");
        Calendar c = Calendar.getInstance();
        customer.setBirthday(c.getTime());

        //加载 hibernate.cfg.xml 配置文件
        Configuration cfg = new Configuration();//加载类路径中的hibernate.properties配置文件
        cfg.configure();//加载类路径中的hibernate.cfg.xml配置文件

        //手工加入要管理的实体或映射文件-1指定实体类
		cfg.addClass(Customer.class);
		//手工加入要管理的实体或映射文件-2指定映射文件
//        cfg.addResource("zsy/hibernate/day1/domain/Customer.hbm.xml");

        //得到SessionFactory实例
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //获取Session:hibernate的一切操作都是基于Session对象
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();//开启事务
        Serializable save = session.save(customer);
        System.out.println("save: " + save + " (" + save.getClass().getName() + ")");//返回新建自增ID主键
        tx.commit();                                //提交事务
        session.close();                            //释放资源
        sessionFactory.close();                     //暂时关闭
    }
}
