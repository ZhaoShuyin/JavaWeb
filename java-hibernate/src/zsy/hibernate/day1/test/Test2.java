package zsy.hibernate.day1.test;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import zsy.hibernate.day1.domain.Customer;
//Configuration一些了解的东西
public class Test2 {
	@Test
	public void testSave(){
		Customer customer = new Customer();
		customer.setName("陈涔");
		Calendar c = Calendar.getInstance();
		c.set(1993, 1, 18);
		customer.setBirthday(c.getTime());
		
		
		//加载hibernate.cfg.xml配置文件，配置文件中没有指定映射文件
		Configuration cfg = new Configuration();//加载类路径中的hibernate.properties配置文件
		cfg.configure();//加载类路径中的hibernate.cfg.xml配置文件
		
		//手工加入要管理的实体或映射文件
//		cfg.addClass(Customer.class);//指定实体类
		cfg.addResource("cn/itcast/domain/Customer.hbm.xml");//指定映射文件
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();//提交事务
		session.close();//释放资源
		sessionFactory.close();//暂时关闭
	}
}
