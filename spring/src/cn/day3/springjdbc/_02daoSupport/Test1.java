package cn.day3.springjdbc._02daoSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Ioc：找Spring要
public class Test1 {

	public static void main(String[] args) {
		ApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"cn/day3/springjdbc/_02daoSupport/beans.xml"
				);
//		DaoImpl2 accountDaoImpl2 = (DaoImpl2) ac.getBean("Impl2");
//		accountDaoImpl2.save();
		test1(ac);
	}

	public static void test1(ApplicationContext ac){
		DaoImpl1 impl1 = (DaoImpl1)ac.getBean("Impl1");
		impl1.insert();
	}

	public static void test2(ApplicationContext ac){
		DaoImpl2 impl2 = (DaoImpl2) ac.getBean("Impl2");
		impl2.save();
	}

	public static void test3(ApplicationContext ac){
		DaoImpl3 impl3 = (DaoImpl3) ac.getBean("Impl3");
//		Account a1 = new Account();
//		a1.setName("aa");
//		a1.setAmount(1000f);
//
//		impl3.save(a1);

//		Account a1 = impl3.findAccountById(1);
//		System.out.println(a1);

//		List<Account> as = impl3.findAllAccounts();
//		System.out.println(as);

//		Account a1 = impl3.findAccountById(1);
//		a1.setName("aaa");
//		impl3.update(a1);
//		impl3.delete(4);

		Object test = impl3.test();
		System.out.println(test);
	}


}
