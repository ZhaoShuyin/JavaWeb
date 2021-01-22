package com.zsy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个剧组，需要找演员演出
 * @author zhy
 *
 */
public class Client {


	public static void main(String[] args) {
		//1.时间点是在上世纪80年代
		final Actor actor = new Actor();

		//2.到了21世纪，经纪人和经纪公司出现了
		/**
		 * 基于接口的动态代理：
		 * 		想要代理的类不实现任何接口，就不能使用。
		 * 动态代理的特点：
		 * 		字节码是随用随创建，随用随加载。
		 * 实现方式
		 * 	  Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
		 * 参数详解：
		 * 	 ClassLoader loader：
		 * 			类加载器，和被代理对象使用的是相同的类加载器。所以是固定写法。
		 *	 Class<?>[] interfaces
		 *			实现的接口，和被代理对象需要具备相同的行为。实现相同的接口。
		 *	 InvocationHandler h
		 *			如何代理。也就是想做什么。
		 *			它用的是一个设计模式：策略模式。
		 *			适用范围：
		 *				数据已经有了
		 *				目标很明确
		 *				如何如何实现目标，谁用谁知道，自己去实现。（实现就叫做策略）
		 */
		IActor proxyActor = (IActor)Proxy.newProxyInstance(actor.getClass().getClassLoader(),
				actor.getClass().getInterfaces(),
				new InvocationHandler() {
					/**
					 * 执行被代理对象的任何方法，都会经过该方法。所以可以说他具有拦截的行为。
					 * 参数详解:
					 * 	  Object proxy：
					 * 			代理对象的引用，不一定用得到。
					 *	  Method method：
					 *			当前执行的方法对象
					 *	  Object[] args
					 *			当前执行方法所需要的参数
					 * 返回值：
					 * 	  Object:当前执行方法的返回值
					 */
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
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




		//拿钱演出
//		actor.basicAct(100);
//		actor.dangerAct(240);


		//有剧组找的演员来演出(代理对象)
		proxyActor.basicAct(20000);
		proxyActor.dangerAct(80000);
		System.out.println(proxyActor.getClass().getName());
	}

}
