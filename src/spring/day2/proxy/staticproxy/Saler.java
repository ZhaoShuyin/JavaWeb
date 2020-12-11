package spring.day2.proxy.staticproxy;
//代理人
public class Saler {
	private ComputerFactory computerFactory;
	public Saler(){
		computerFactory = new ComputerFactory();
	}
	public void sale(float money){
		//抽成：
		computerFactory.genComputer(money);
		//返点：
	}
}
