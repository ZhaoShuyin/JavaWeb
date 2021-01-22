package cn.day1.spring_02init;

/**
 * 静态工厂：方法都是静态方法
 */
public class StaticFactory {

    public StaticFactory() {
        System.out.println("=======> 静态工厂 构造方法");
    }

    public static IUser genUserInstance() {
        System.out.println("静态工厂 静态方法 创建 User");
        return new UserImpl();
    }
}
