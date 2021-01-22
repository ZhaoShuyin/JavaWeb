package cn.day1.spring_01IoC;

public class UserImpl implements IUser {

	public UserImpl() {
		System.out.println("UserImpl 构造方法");
	}

	public void save() {
		System.out.println("UserImpl save 方法 ....");
	}
}
