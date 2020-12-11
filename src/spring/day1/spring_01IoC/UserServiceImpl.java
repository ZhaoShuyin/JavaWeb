package spring.day1.spring_01IoC;

public class UserServiceImpl implements UserService {
	
	public UserServiceImpl(){
		System.out.println("UserSerivceImpl 的构造函数");
	}
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		System.out.println("UserSerivceImpl 的 成员变量Set 方法 1");
		this.userDao = userDao;
	}
	public void regist() {
		userDao.save();
	}

	private User user;

	public void setUser(User user) {
		System.out.println("UserSerivceImpl 的 成员变量Set 方法 2");
		this.user = user;
	}
}
