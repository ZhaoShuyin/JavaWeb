package zsy.hibernate.day33.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//创建一个SessionFactory
	private static final SessionFactory sessionFactory;//唯一
	//初始化
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	public static void main(String[] args) {
		Session s = openSession();//初始化一次，产生表结构
		s.close();
	}
}
