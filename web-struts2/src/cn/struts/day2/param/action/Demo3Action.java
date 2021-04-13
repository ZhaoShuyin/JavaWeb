package cn.struts.day2.param.action;


import com.opensymphony.xwork2.ActionSupport;

import cn.struts.day2.param.domain.Person;

/**
 * 动作类：只完成动作处理
 * <p>
 * a
 */
public class Demo3Action extends ActionSupport {

    private Person person = new Person();

    public Person getPerson() {
        System.out.println("getPerson");
        return person;
    }

    public void setPerson(Person person) {
        System.out.println("setPerson");
        this.person = person;
    }

    public String execute() {
        System.out.println("Demo3Action...." + person);
        return null;
    }

}
