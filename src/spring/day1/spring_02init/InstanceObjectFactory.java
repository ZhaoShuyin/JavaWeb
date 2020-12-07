package spring.day1.spring_02init;
//实例工厂：需要实例化工厂本身，才能调用自身的实例方法
public class InstanceObjectFactory {
	public UserDao genUserDaoInstance(){
		return new UserDaoImpl();
	}
}
