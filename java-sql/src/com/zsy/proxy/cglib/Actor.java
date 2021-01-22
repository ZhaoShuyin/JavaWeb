package com.zsy.proxy.cglib;
/**
 * 一个演员类
 */
public class Actor{

	public void basicAct(float money){
		System.out.println("拿到钱，开始基本的演出："+money);
	}

	public void dangerAct(float money){
		System.out.println("拿到钱，开始危险的演出："+money);
	}
}
