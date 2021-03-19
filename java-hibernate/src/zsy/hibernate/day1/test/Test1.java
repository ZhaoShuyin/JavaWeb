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
 * Hibernate是一个持久层ORM(Object Relational Mapping)框架
 * <p>
 * JPA 持久层框架标准
 * <p>
 * 入门案例
 * 变现层
 * 业务层
 * 持久层
 */
public class Test1 {

    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setName("名称");
        Calendar c = Calendar.getInstance();
        customer.setBirthday(c.getTime());

        //加载 hibernate.configuration.xml 配置文件
        Configuration configuration = new Configuration();//加载类路径中的hibernate.properties配置文件
        configuration.configure();//加载类路径中的hibernate.configuration.xml配置文件

        //手工加入要管理的实体或映射文件-1指定实体类
        configuration.addClass(Customer.class);
        //手工加入要管理的实体或映射文件-2指定映射文件
//        configuration.addResource("zsy/hibernate/day1/domain/Customer.hbm.xml");

        //得到SessionFactory实例
        SessionFactory sessionFactory = configuration.buildSessionFactory();
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
