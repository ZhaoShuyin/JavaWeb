package cn.struts.day2.param.action;

import com.opensymphony.xwork2.ActionSupport;
//动作类：只完成动作处理.模型驱动
import com.opensymphony.xwork2.ModelDriven;

import cn.struts.day2.param.domain.Person;

/*
 * 一定要记住：
 * 1、实例化模型对象：即一定要new出来
 * 2、动作类实现一个接口：ModelDriven
 * 3、实现接口中的方法：返回模型对象
 */
public class Demo4Action extends ActionSupport implements ModelDriven<Person> {//2

    private Person person = new Person();//1

    public String execute() {
        System.out.println("Demo4Action...." + person);
        return null;
    }

    //3
    public Person getModel() {
        return person;
    }
}
