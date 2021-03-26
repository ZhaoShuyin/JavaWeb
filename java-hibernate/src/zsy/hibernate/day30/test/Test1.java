package zsy.hibernate.day30.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day30.domain.Student;
import zsy.hibernate.day30.domain.Teacher;
import zsy.hibernate.day30.util.HibernateUtil;
//多对多相关操作
public class Test1 {

	//删除：不要配置级联删除
	//因为删除老师（或学生）：默认先删除关系表相关记录。再删除老师（或学生）记录。
	//cascade="delete" 配置这个后关联数据也会被删除
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Teacher t3 = (Teacher)s.get(Teacher.class, 3);
		System.out.println(t3);
		s.delete(t3);
		tx.commit();
		s.close();
	}

	/**
	 * 保存:不要双向建立关联关系
	 */
	@Test
	public void test1(){
		Teacher t1 = new Teacher();
		t1.setName("T1");
		t1.setSalary(10000f);
		
		Teacher t2 = new Teacher();
		t2.setName("T2");
		t2.setSalary(10000f);
		
		Student s1 = new Student();
		s1.setName("S1");
		s1.setGrade("A");
		
		Student s2 = new Student();
		s2.setName("S2");
		s2.setGrade("A");
		
		//建立关联关系：双向关联（不要）
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t2.getStudents().add(s1);
		t2.getStudents().add(s2);
		
//		s1.getTeachers().add(t1);
//		s1.getTeachers().add(t2);
//		s2.getTeachers().add(t1);
//		s2.getTeachers().add(t2);
		
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(t1);
		s.save(t2);
		s.save(s1);
		s.save(s2);
		
		tx.commit();
		s.close();
	}
}
