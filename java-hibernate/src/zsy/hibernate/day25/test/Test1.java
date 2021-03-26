package zsy.hibernate.day25.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.HashSet;

import zsy.hibernate.day25.util.HibernateUtil;
import zsy.hibernate.day25.domain.Student;
import zsy.hibernate.day25.domain.Teacher;

public class Test1 {

	@Test
	public void test1(){
		Teacher teacher1 = new Teacher();
		teacher1.setName("张老师");
		teacher1.setSalary(100f);
		Teacher teacher2 = new Teacher();
		teacher2.setName("李老师");
		teacher2.setSalary(200f);
		HashSet<Teacher> teachers = new HashSet<>();
		teachers.add(teacher1);
		teachers.add(teacher2);

		Student student1 = new Student();
		student1.setName("小明");
		student1.setGrade("三年级");
		student1.setTeachers(teachers);
		Student student2 = new Student();
		student2.setName("小红");
		student2.setGrade("三年级");
		student2.setTeachers(teachers);
		HashSet<Student> students = new HashSet<>();
		students.add(student1);
		students.add(student2);

		teacher1.setStudents(students);
		teacher2.setStudents(students);

		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(teacher1);
		session.save(teacher2);
		session.save(student1);
		session.save(student2);
		transaction.commit();
		session.close();
	}
}
