package com.spring.day2.proxy.staticproxy;
//客户
public class Customer {
	public static void main(String[] args) {
//		ComputerFactory cf = new ComputerFactory();
//		cf.genComputer(1000f);//厂家直销
		
		Saler saler = new Saler();//通过代理购买的。代理
		saler.sale(2000f);
	}
}
