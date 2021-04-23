package zsy.hibernate.day23.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

import zsy.hibernate.day23.domain.Category;
import zsy.hibernate.day23.util.HibernateUtil;

/**
 * 关联关系测试
 */
public class Test1 {

    @Test
    public void test1() {

        Category computer = new Category("电脑");
        Category notepad = new Category("笔记本");
        Category pad = new Category("平板电脑");
        Category thinkpad = new Category("thinkpad");

        //建立关联关系：双向
        computer.getChildCategory().add(notepad);
        notepad.setParentCategory(computer);
        computer.getChildCategory().add(pad);
        pad.setParentCategory(computer);

        notepad.getChildCategory().add(thinkpad);
        thinkpad.setParentCategory(notepad);


        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();

        Serializable save = s.save(computer);
        System.out.println("save: " + save + " (" + save.getClass().getName() + ")");//返回新建自增ID主键

        tx.commit();
        s.close();

    }
}