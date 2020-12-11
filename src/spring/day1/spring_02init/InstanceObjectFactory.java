package spring.day1.spring_02init;
//实例工厂：需要实例化工厂本身，才能调用自身的实例方法
public class InstanceObjectFactory {
	public InstanceObjectFactory() {
		System.out.println("InstanceObjectFactory 构造函数");
	}

	public UserDao genUserDaoInstance(){
		System.out.println("工厂类方法创建对象");
		return new UserDaoImpl();
	}
}
