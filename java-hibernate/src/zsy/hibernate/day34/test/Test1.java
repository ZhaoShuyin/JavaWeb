package zsy.hibernate.day34.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day34.domain.Customer;
import zsy.hibernate.day34.util.HibernateUtil;

//各种查询：HQL
public class Test1 {
    //分页查询
    //MYSQL: limit m,n;  m:开始记录的索引，n：一次取出的条数
    //Oracle: 需要事务支持。 m,n  m:开始记录的索引，n：结束记录的索引
    //不同数据库：分页语句是不同的。在Hibernate全部统一成了类似MySQL的形式。
    @Test
    public void test5() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Customer");
        //设置分页参数
        q.setFirstResult(0);//开始记录的索引
        q.setMaxResults(2);//一次取出的条数
        List<Customer> cs = q.list();
        for (Customer c : cs)
            System.out.println(c);

        tx.commit();
        s.close();

    }

    //排序
    @Test
    public void test4() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Customer c order by c.id desc");

        List<Customer> cs = q.list();
        for (Customer c : cs)
            System.out.println(c);

        tx.commit();
        s.close();

    }

    //HQL设置查询参数:具名查询(给参数取了一个名字)
    @Test
    public void test3() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Customer c where c.id=:id and c.name=:name");
        //设置参数
        q.setInteger("id", 1);
        q.setString("name", "客户1");

        List<Customer> cs = q.list();
        for (Customer c : cs)
            System.out.println(c);

        tx.commit();
        s.close();

    }

    //HQL:模糊查询
    @Test
    public void test2() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        //查询客户name=客户1 id=1的记录
        //HQL:面向对象的查询。类名而不是表名。c.id是调用Customer对象的getId/setId，而不是字段
        Query q = s.createQuery("from Customer c where c.name like ?");
        //设置参数

        q.setString(0, "%" + "客户" + "%");

        List<Customer> cs = q.list();
        for (Customer c : cs)
            System.out.println(c);

        tx.commit();
        s.close();

    }

    //HQL设置查询参数
    @Test
    public void test1() {
        Session s = HibernateUtil.openSession();
        Transaction tx = s.beginTransaction();
        //查询客户name=客户1 id=1的记录
        //HQL:面向对象的查询。类名而不是表名。c.id是调用Customer对象的getId/setId，而不是字段
        Query q = s.createQuery("from Customer c where c.id=? and c.name=?");
        //设置参数
        q.setInteger(0, 1);//参数的索引从0开始
        q.setString(1, "客户1");

//		List<Customer> cs = q.list();
//		for(Customer c:cs)
//			System.out.println(c);

        //如果你能确认结果只会有一条（根据唯一的字段查询）
        Customer c = (Customer) q.uniqueResult();//如果结果不唯一，报错
        System.out.println(c);
        tx.commit();
        s.close();

    }
}
