package spring.day1.spring_02init;
//静态工厂：方法都是静态方法
public class StaticObjectFactory {
	public static UserDao genUserDaoInstance(){
		return new UserDaoImpl();
	}
}
