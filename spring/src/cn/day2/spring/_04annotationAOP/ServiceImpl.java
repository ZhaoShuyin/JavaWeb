package cn.day2.spring._04annotationAOP;

import org.springframework.stereotype.Component;

//使用@Component注解 注明 id = accountService
@Component("accountService")
public class ServiceImpl {

    //
    public String transfer() {
        System.out.println("业务实现代码....transfer方法执行了");
        return "ok";
    }

    //
    public void transfer1() {
        System.out.println("业务实现代码....transfer1方法执行了");
    }
}
