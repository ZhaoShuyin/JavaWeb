package zsy.hibernate.day1.test;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import zsy.hibernate.day1.domain.Customer;
//入门案例
public class Test1 {

	@Test
	public void testSave(){
		Customer customer = new Customer();
		customer.setName("陈涔");
		Calendar c = Calendar.getInstance();
		c.set(1993, 1, 18);
		customer.setBirthday(c.getTime());
		
		
		//加载hibernate.cfg.xml配置文件
		Configuration cfg = new Configuration();//加载类路径中的hibernate.properties配置文件
		cfg.configure();//加载类路径中的hibernate.cfg.xml配置文件
		//得到SessionFactory实例
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//获取Session:hibernate的一切操作都是基于Session对象
		Session session = sessionFactory.openSession();
		//开启事务：
		Transaction tx = session.beginTransaction();
		Serializable save = session.save(customer);
		System.out.println("save: "+save);
		tx.commit();//提交事务
		session.close();//释放资源
		sessionFactory.close();//暂时关闭
	}
}
