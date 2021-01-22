package cn.day1.spring_04lifecycle;

public class UserImpl implements IUser {

    public UserImpl() {
        System.out.println("UserImpl 构造方法");
    }

    //初始化方法：执行一次
    public void init() {
        System.out.println("UserDaoImpl....init 初始化方法");
    }

    public void save() {
        System.out.println("UserDaoImpl save....");
    }

    //销毁方法：销毁一次。spring容器关闭时.只有单例模式才有意义
    public void destroy() {
        System.out.println("UserDaoImpl....destroy 销毁方法");
    }
}
