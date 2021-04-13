package cn.struts.day1.action;

import com.sun.net.httpserver.Authenticator;

//动作类：struts2中的动作类就是一个POJO（Plain Old Java Object最简单的JavaBean对象）
public class HelloAction {
    //动作方法:书写要求
    //1、返回值类型必须是String
    //2、方法不能有参数
    //3、声明一般都是public
    public String sayHello() {
        String s = "Action =================== HelloAction sayHello .....";
        System.out.println(s);
        return "success";
    }
}
