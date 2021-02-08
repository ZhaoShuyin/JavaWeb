package zsy.hibernate.day1.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day1.domain.Student;
import zsy.hibernate.day1.util.HibernateUtil;
public class Test5 {
	@Test
	public void testSave(){
		Student s = new Student();
		s.setName("阿诺.斯瓦辛格");
		
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();//提交事务
		session.close();//释放资源
	}
}
