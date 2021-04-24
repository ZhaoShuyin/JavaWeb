package cn.day2.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * 使用cglib代理
 */
public class Test {

    public static void main(String[] args) {

        Actor h = new Actor();                 //目标对象：被代理对象
        System.out.println("调用sing方法");
        h.sing(500f);
        System.out.println("调用dance方法");
        h.dance(500f);
        System.out.println("=======================================");

        Enhancer e = new Enhancer();               //增强
        e.setSuperclass(Actor.class);              //指定被代理类
        e.setCallback(new MyMethodInterceptor(h)); //指定代理类

        //基于子类的代理。代理对象可以看成父类
        Actor proxy = (Actor) e.create();
        System.out.println("调用sing方法");
        proxy.sing(10000f);
        System.out.println("调用dance方法");
        proxy.dance(20000f);
    }
}

