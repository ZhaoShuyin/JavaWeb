package com.spring.day1.spring_02init;

//静态工厂：方法都是静态方法
public class StaticObjectFactory {

    public StaticObjectFactory() {
        System.out.println("StaticObjectFactory 构造函数");
    }

    /**
     * 静态方法初始化时就会执行
     * 多次调用不会重复执行
     *
     * @return
     */
    public static UserDao genUserDaoInstance() {
        System.out.println("工厂类静态方法创建对象");
        return new UserDaoImpl();
    }
}
