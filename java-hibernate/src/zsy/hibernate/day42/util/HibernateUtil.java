package zsy.hibernate.day42.util;

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
		return sessionFactory.openSession();//开启新的Session：手工
	}
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();//从当前线程上获取
	}
	public static void main(String[] args) {
		Session s = openSession();//初始化一次，产生表结构
		s.close();
	}
}
