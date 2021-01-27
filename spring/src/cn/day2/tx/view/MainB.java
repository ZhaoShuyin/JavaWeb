package cn.day2.tx.view;

import cn.day2.tx.service.IService;
import cn.day2.tx.service.impl.ServiceB;

public class MainB {

	public static void main(String[] args) {
		IService s = new ServiceB();
		s.transfer("aaa", "bbb", 1f);
	}

}
