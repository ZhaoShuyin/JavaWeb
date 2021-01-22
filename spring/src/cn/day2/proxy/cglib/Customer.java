package cn.day2.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * 代理
 */
public class Customer {

    public static void main(String[] args) {

        SpringBrother h = new SpringBrother();//目标对象：被代理对象

        Enhancer e = new Enhancer();//增强
        e.setSuperclass(SpringBrother.class);//指定代理类的父类

        e.setCallback(new MyMethodInterceptor(h));

        //基于子类的代理。代理对象可以看成父类
        SpringBrother proxy = (SpringBrother) e.create();
        System.out.println("调用sing方法");
        proxy.sing(10000f);
        System.out.println("调用dance方法");
        proxy.dance(20000f);
    }
}

