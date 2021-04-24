package cn.day2.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//代理对象：拦截的功能
public class MyMethodInterceptor implements MethodInterceptor {
    private Actor h;//被代理对象

    public MyMethodInterceptor(Actor h) {
        this.h = h;
    }

    //调用代理对象的任何方法，都会经过该方法
    /*
     *Object proxy:代理对象本身的引用。目前用不到
     *Method method:当前调用的代理对象的方法
     *Object[] args:当前调用的方法用到的参数
     *返回值：当前调用的方法的返回值
     */
    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        //拿到被调用方法的参数
        float money = (Float) args[0];
        String name = method.getName();
        System.out.println("过滤方法 : " + name + " , value: " + money);
        if ("sing".equals(name)) {
            if (money >= 10000)
                method.invoke(h, money / 2);
        }
        if ("dance".equals(name)) {
            if (money >= 20000)
                method.invoke(h, money / 2);
        }
//				method.invoke(h, args);//  h.sing()对象调用方法；method.invoke(h,args)方法被哪个对象调用
        return null;
    }

}