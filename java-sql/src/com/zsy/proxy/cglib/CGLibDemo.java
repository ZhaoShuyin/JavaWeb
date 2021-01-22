package com.zsy.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ����û��ʵ���κνӿڵ��࣬Ҫ��ʵ�ֶ�̬��������Ҫʹ�õ���������CGLIB
 * ��������Ķ�̬����
 *
 * ʵ�ʿ����У���ʹ�û��ڽӿڵģ��Ͳ�Ҫʹ�û��������
 * @author zhy
 *
 */
public class CGLibDemo {

	public static void main(String[] args) {
		final Actor actor = new Actor();
		/**
		 * ʵ�ַ�ʽ��
		 * 	Enhancer.create(����1������2)
		 * ������⣺
		 * 	 ����1��Ҫ���������ֽ���
		 * 	 ����2����δ���
		 */
		Actor proxyactor = (Actor)Enhancer.create(actor.getClass(), new MethodInterceptor() {
			/**
			 * ִ�б����������κη��������ᾭ���÷�����
			 * ������⣺
			 * 	  Object proxy��
			 * 			�����������ã���һ���õõ���
			 *	  Method method��
			 *			��ǰִ�еķ�������
			 *	  Object[] args
			 *			��ǰִ�з�������Ҫ�Ĳ���
			 *	  MethodProxy methodproxy:
			 *			��ǰִ�з����Ĵ������
			 * ����ֵ��
			 * 	 ��ǰִ�з����ķ���ֵ
			 */
			public Object intercept(Object proxy, Method method, Object[] args,
									MethodProxy methodproxy) throws Throwable {
				//�ݳ�����
				float money = (Float)args[0];
				if(money > 10000){
					//�ж���ʲô�ݳ�
					if("basicAct".equals(method.getName())){
						return method.invoke(actor,money/2);
					}
				}
				if(money > 20000){
					//�ж���ʲô�ݳ�
					if("dangerAct".equals(method.getName())){
						return method.invoke(actor,money/4);
					}
				}
				return null;
			}
		});


		//�ݳ�
		proxyactor.basicAct(15000);
		proxyactor.dangerAct(28000);
	}

}
