package zsy.hibernate.day20.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//创建一个SessionFactory
	private static final SessionFactory sessionFactory;//唯一
	//初始化
	static{
		sessionFactory = new Configuration()
				.configure("zsy/hibernate/day20/hibernate.cfg.xml").buildSessionFactory();
	}
	public static Session openSession(){
		return sessionFactory.openSession();
	}
}
