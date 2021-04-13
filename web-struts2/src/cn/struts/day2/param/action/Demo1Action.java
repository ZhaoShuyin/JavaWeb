package cn.struts.day2.param.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 测试静态参数
 */
public class Demo1Action extends ActionSupport {
    private String name = "陈岑";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() {
        System.out.println(" =============== Demo1Action,  name: " + name);
        return null;
    }
}
