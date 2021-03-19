package zsy.hibernate.day1.test;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day1.domain.Person;
import zsy.hibernate.day1.util.HibernateUtil;

/**
 * 映射属性
 */
public class Test4 {

    /**
     * <property name="registDate" type="timestamp" insert="true" column="REGISTDATE"></property>
     * insert="true" 允许插入该列
     */
    @Test
    public void testSave() {
        Person p = new Person();
        p.setName("姓名");
        p.setIdcard("1111111");
        Calendar c = Calendar.getInstance();
        c.set(1999, 1, 10);
        p.setRegistDate(c.getTime());

        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Serializable save = session.save(p);
        tx.commit();//提交事务
        session.close();//释放资源
        System.out.println("save:" + save + "(" + save.getClass().getName() + ")");
    }

    /**
     * update="false" 属性不可修改
     * <property name="idcard" column="IDCARD" update="false"></property>
     */
    @Test
    public void testUpdate() {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = (Person) session.get(Person.class, 1);
        System.out.println(person.getId() + " == " + person.getIdcard());
        person.setIdcard("22222");
        person.setName("修改姓名");
        session.update(person);
        transaction.commit();       //提交事务
        session.close();            //释放资源
    }
}
