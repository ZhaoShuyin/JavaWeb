package cn.day1.spring_02init;

/**
 * 实例工厂：需要实例化工厂本身，才能调用自身的实例方法
 */
public class InstanceFactory {

    public InstanceFactory() {
        System.out.println("=======> 实例工厂 构造方法");
    }

    public IUser genUserInstance() {
        System.out.println("实例工厂 实例方法 创建User");
        return new UserImpl();
    }
}
