package cn.day2.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 *
 */
public class Test {

    public static void main(String[] args) {
        Human human = new Actor();//目标对象：被代理对象
        //基于接口的动态代理：被代理类要实现某个（些）接口
		/*
		 ClassLoader loader:代理类自动生成的，也必须有类加载器来加载。
		 					固定写法,和被代理对象使用相同的即可
		 Class[] interfaces:代理类要实现的接口。目的代理类和被代理类有着相同的行为
		 					固定写法，和被代理类实现相同的接口即可
		 
		 InvocationHandler human:如何代理（策略模式）
		 */
        Class<? extends Human> aClass = human.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        Class<?>[] interfaces = aClass.getInterfaces();
        Human proxy = (Human) Proxy.newProxyInstance(
                classLoader,
                interfaces,
                new MyInvocationHandler(human)
        );
        proxy.sing(10000f);
//        proxy.dance(20000f);
    }
}
