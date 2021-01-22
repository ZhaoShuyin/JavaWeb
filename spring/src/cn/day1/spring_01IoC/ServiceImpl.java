package cn.day1.spring_01IoC;

public class ServiceImpl implements IService {
	
	public ServiceImpl(){
		System.out.println("ServiceImpl 构造方法");
	}
	
	private IUser userDao;

	public void setUserDao(IUser userDao) {
		System.out.println("ServiceImpl 成员变量设置方法");
		this.userDao = userDao;
	}

	public void regist() {
		System.out.println("ServiceImpl regist 方法");
		userDao.save();
	}

}
