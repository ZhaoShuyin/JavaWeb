package spring.day1.spring_01IoC;

public class UserServiceImpl implements UserService {
	
	public UserServiceImpl(){
		System.out.println("UserSerivceImpl default constructor.....");
	}
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void regist() {
		userDao.save();
	}

}
