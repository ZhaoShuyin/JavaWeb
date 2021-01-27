package cn.day2.proxy.cglib;
//类要求不能是final的
public class Actor {

	public void sing(float money) {
		System.out.println("拿到钱："+money+" 开唱");
	}

	public void dance(float money) {
		System.out.println("拿到钱："+money+" 开跳");
	}

}
