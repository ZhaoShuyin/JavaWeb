package cn.day2.tx.view;

import java.lang.reflect.Proxy;

import cn.day2.tx.service.IService;
import cn.day2.tx.service.impl.ServiceC;

public class MainC {

    public static void main(String[] args) {
        IService s = new ServiceC();//被代理对象。没有事务的
        System.out.println("创建被代理对象");
        //得到它的代理对象:织入（把公用代码在运行期间加入到核心业务代码中）
        IService proxy = (IService) Proxy.newProxyInstance(
                s.getClass().getClassLoader(),
                s.getClass().getInterfaces(),
                new MyInvocationHandler(s));
        System.out.println("创建代理对象");
        proxy.transfer("aaa", "bbb", 1f);
        System.out.println("执行方法(代理)");
    }

}

