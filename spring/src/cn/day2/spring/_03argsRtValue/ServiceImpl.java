package cn.day2.spring._03argsRtValue;


public class ServiceImpl {
    public void transfer(String name) {
        System.out.println("业务实现代码....transfer方法执行了");
    }

    public String login() {
        System.out.println("login................");
        return "Login";
    }

    public void transfer1() {//知道发生了什么异常
        System.out.println("业务实现代码....transfer1方法执行了");
        int i = 1 / 0;
    }

}
