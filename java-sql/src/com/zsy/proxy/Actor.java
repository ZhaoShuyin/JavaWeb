package com.zsy.proxy;
/**
 * 一个演员类
 * @author zhy
 *
 */
public class Actor implements IActor {

	public void basicAct(float money){
		System.out.println("拿到钱，开始基本的演出："+money);
	}

	public void dangerAct(float money){
		System.out.println("拿到钱，开始危险的演出："+money);
	}
}
