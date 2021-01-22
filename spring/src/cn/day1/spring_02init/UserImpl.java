package cn.day1.spring_02init;

public class UserImpl implements IUser {

	public UserImpl() {
		System.out.println("=======> UserImpl 构造方法");
	}

	public void save() {
		System.out.println("UserDaoImpl save....");
	}
}
