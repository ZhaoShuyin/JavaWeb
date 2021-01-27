package cn.day2.spring._01aop;

//公用代码
//该类一般叫做通知类
public class TransactionManager {

	public void beforeMethod(){
		System.out.println(" >>>>>>>>>> before method >>>>>>>>>>");
	}
	public void afterMethod(){
		System.out.println(" <<<<<<<<<< after method <<<<<<<<<<");
	}
}
