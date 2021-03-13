package zsy.hibernate.day1.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

import zsy.hibernate.day1.domain.Student;
import zsy.hibernate.day1.util.HibernateUtil;

public class Test3 {
    @Test
    public void testSave() {
        Student s = new Student();
        s.setName("阿诺.斯瓦辛格");
        s.setId(1);
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Serializable save = session.save(s);
        tx.commit();      //提交事务
        session.close();  //释放资源
        System.out.println("save:" + save + "(" + save.getClass().getName() + ")");
    }
}
