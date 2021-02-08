package zsy.hibernate.day34.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Test;

import zsy.hibernate.day34.domain.Customer;
import zsy.hibernate.day34.util.HibernateUtil;

//各种查询：QBC
public class Test2 {
    //QBE:模板查询
    //使用前提：
    //实体类中的所有字段都使用包装类型（不能使用基本类型）
    //会把Example对象中的所有非null字段都作为查询条件（and查询）
    //按照实体的多个字段进行查询时比较有用
    @Test
    public void test3() {
        //准备Example
        Customer example = new Customer();
        example.setName("客户1");

        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Criteria c = s.createCriteria(Customer.class);//告知查询的实体
        c.add(Example.create(example));//select * from customers where name="客户1"
        List<Customer> cs = c.list();
        for (Customer cus : cs)
            System.out.println(cus);


        tx.commit();
        s.close();

    }

    //QBC:模糊查询
    @Test
    public void test2() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Criteria c = s.createCriteria(Customer.class);//告知查询的实体
        c.add(Restrictions.eq("name", "%客户%"));
        List<Customer> cs = c.list();
        for (Customer cus : cs)
            System.out.println(cus);


        tx.commit();
        s.close();

    }

    //QBC设置查询参数
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Criteria c = s.createCriteria(Customer.class);//告知查询的实体
        c.add(Restrictions.eq("id", 1));//添加条件Criterion
        c.add(Restrictions.eq("name", "客户1"));
        List<Customer> cs = c.list();
        for (Customer cus : cs)
            System.out.println(cus);

        tx.commit();
        s.close();

    }
}
