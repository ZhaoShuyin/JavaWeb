package spring.day1.spring_01IoC;

public class UserDaoImpl implements UserDao {

	//必须是无参构造方法
	public UserDaoImpl() {
		System.out.println("UserDaoImpl 的 构造函数");
	}

	public void save() {
		System.out.println("UserDaoImpl save....");
	}
}
