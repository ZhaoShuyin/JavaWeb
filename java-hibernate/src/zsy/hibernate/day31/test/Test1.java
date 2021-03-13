package zsy.hibernate.day31.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day31.domain.IPerson;
import zsy.hibernate.day31.domain.IdCard;
import zsy.hibernate.day31.util.HibernateUtil;

/**
 * @Title zsy.hibernate.day31.test
 * @date 2021/3/10
 * @autor Zsy
 */

public class Test1 {

    @Test
    public void Test() {
        IPerson iPerson = new IPerson();
        iPerson.setName("名称");
        IdCard idCard = new IdCard();
        idCard.setNum("101-102");

        iPerson.setIdCard(idCard);
        idCard.setPerson(iPerson);


        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(idCard);
        transaction.commit();
        session.close();
    }

}
