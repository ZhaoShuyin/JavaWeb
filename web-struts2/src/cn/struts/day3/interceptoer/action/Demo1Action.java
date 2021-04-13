package cn.struts.day3.interceptoer.action;

import com.opensymphony.xwork2.ActionSupport;


public class Demo1Action extends ActionSupport {

    public String execute() {
        System.out.println("Demo1Action......");
        return SUCCESS;
    }
}
