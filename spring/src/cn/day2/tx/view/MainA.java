package cn.day2.tx.view;

import cn.day2.tx.service.IService;
import cn.day2.tx.service.impl.ServiceA;

public class MainA {

	public static void main(String[] args) {
		System.out.println("======================= MVC >> transfer");
		IService s = new ServiceA();
		s.transfer("aaa", "bbb", 1f);
	}

}
