package zsy.hibernate.day25.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zsy.hibernate.day24.domain.Address;
import zsy.hibernate.day24.domain.Customer;
import zsy.hibernate.day24.util.HibernateUtil;
public class Test1 {

	@Test
	public void test1(){
		Customer c = new Customer();
		c.setName("杜巍锋");

		Address homeAddress = new Address();
		homeAddress.setProvince("河南省");
		homeAddress.setCity("周口市");
		homeAddress.setStreet("XXXX街道");

		Address comAddress = new Address();
		comAddress.setProvince("北京市");
		comAddress.setCity("海淀区");
		comAddress.setStreet("四拨子");

		c.setComAddress(comAddress);
		c.setHomeAddress(homeAddress);//不是建立关联关系，仅仅是设置值而已

		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();

		s.save(c);

		tx.commit();
		s.close();

	}
}
