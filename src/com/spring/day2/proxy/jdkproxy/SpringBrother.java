package com.spring.day2.proxy.jdkproxy;

public class SpringBrother implements Human{

	public void sing(float money) {
		System.out.println("拿到钱："+money+"开唱");
	}

	public void dance(float money) {
		System.out.println("拿到钱："+money+"开跳");
	}

}
