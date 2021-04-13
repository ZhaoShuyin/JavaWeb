package cn.struts.day2.param.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 动作类就是模型类
 * <p>
 * 接收表单提交的数据(通过Setter方法)
 */
public class Demo2Action extends ActionSupport {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String execute() {
        System.out.println("======   Demo2Action...." + name + "\t" + age);
        return null;
    }
}
