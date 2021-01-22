package com.zsy.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 对于没有实现任何接口的类，要想实现动态代理，则需要使用第三方包：CGLIB
 * 基于子类的动态代理
 *
 * 实际开发中，能使用基于接口的，就不要使用基于子类的
 * @author zhy
 *
 */
public class CGLibDemo {

	public static void main(String[] args) {
		final Actor actor = new Actor();
		/**
		 * 实现方式：
		 * 	Enhancer.create(参数1，参数2)
		 * 参数详解：
		 * 	 参数1：要代理对象的字节码
		 * 	 参数2：如何代理
		 */
		Actor proxyactor = (Actor)Enhancer.create(actor.getClass(), new MethodInterceptor() {
			/**
			 * 执行被代理对象的任何方法，都会经过该方法。
			 * 参数详解：
			 * 	  Object proxy：
			 * 			代理对象的引用，不一定用得到。
			 *	  Method method：
			 *			当前执行的方法对象
			 *	  Object[] args
			 *			当前执行方法所需要的参数
			 *	  MethodProxy methodproxy:
			 *			当前执行方法的代理对象
			 * 返回值：
			 * 	 当前执行方法的返回值
			 */
			public Object intercept(Object proxy, Method method, Object[] args,
									MethodProxy methodproxy) throws Throwable {
				//演出费用
				float money = (Float)args[0];
				if(money > 10000){
					//判断是什么演出
					if("basicAct".equals(method.getName())){
						return method.invoke(actor,money/2);
					}
				}
				if(money > 20000){
					//判断是什么演出
					if("dangerAct".equals(method.getName())){
						return method.invoke(actor,money/4);
					}
				}
				return null;
			}
		});


		//演出
		proxyactor.basicAct(15000);
		proxyactor.dangerAct(28000);
	}

}
