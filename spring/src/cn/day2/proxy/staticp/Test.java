package cn.day2.proxy.staticp;

//客户
public class Test {

    public static void main(String[] args) {
//		ComputerFactory cf = new ComputerFactory();
//		cf.genComputer(1000f);//厂家直销

        Saler saler = new Saler();//通过代理购买的。代理
        saler.sale(2000f);
    }

}
