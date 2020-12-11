package spring.day2.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Customer {

	public static void main(String[] args) {
		Human h = new SpringBrother();//目标对象：被代理对象
		//基于接口的动态代理：被代理类要实现某个（些）接口
		/*
		 ClassLoader loader:代理类自动生成的，也必须有类加载器来加载。
		 					固定写法,和被代理对象使用相同的即可
		 Class[] interfaces:代理类要实现的接口。目的代理类和被代理类有着相同的行为
		 					固定写法，和被代理类实现相同的接口即可
		 
		 InvocationHandler h:如何代理（策略模式）
		 */
		Human proxy = (Human)Proxy.newProxyInstance(
				h.getClass().getClassLoader(), 
				h.getClass().getInterfaces(), 
				new MyInvocationHandler(h));
		proxy.sing(10000f);
		proxy.dance(20000f);
	}
}
//代理对象：拦截的功能
class MyInvocationHandler implements InvocationHandler{
	private Human h;//被代理对象
	public MyInvocationHandler(Human h){
		this.h = h;
	}
	//调用代理对象的任何方法，都会经过该方法
	/*
	 *Object proxy:代理对象本身的引用。目前用不到
	 *Method method:当前调用的代理对象的方法
	 *Object[] args:当前调用的方法用到的参数
	 *返回值：当前调用的方法的返回值
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//拿到被调用方法的参数
		float money = (Float)args[0];
		if("sing".equals(method.getName())){
			if(money>=10000)
				method.invoke(h, money/2);
		}
		if("dance".equals(method.getName())){
			if(money>=20000)
				method.invoke(h, money/2);
		}
//		method.invoke(h, args);//  h.sing()对象调用方法；method.invoke(h,args)方法被哪个对象调用
		return null;
	}
	
}
