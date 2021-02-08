package zsy.hibernate.day1.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day1.domain.Teacher;
import zsy.hibernate.day1.util.HibernateUtil;
public class Test7 {
	@Test
	public void testSave(){
		Teacher t = new Teacher();
		t.setName("苍老师");
		t.setSalary(100000F);
		for(int i=0;i<30;i++){
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			session.save(t);
			tx.commit();//提交事务
			session.close();//释放资源
		}
	}
	/*
	 * 已经在SessionFactory定义好的：更新的是所有映射的字段（除了主键）
	 * Hibernate: update T_TEACHERS set NAME=?, SALARY=? where ID=? 
	 * 
	 * 希望：Hibernate: update T_TEACHERS set SALARY=? where ID=? 
	 * 此语句在SessionFactory中是没有的，动态生成。
	 * 只要这样做：映射文件<class name="Teacher" table="T_TEACHERS" dynamic-update="true">
	 * 
	 * 对于实体类属性特别多时，修改提升效率。
	 * 
	 */
	@Test
	public void testUpdate(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		t.setSalary(100000f);
		tx.commit();//提交事务
		session.close();//释放资源
	}
}
