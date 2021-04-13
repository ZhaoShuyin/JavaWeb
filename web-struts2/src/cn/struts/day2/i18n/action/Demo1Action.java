package cn.struts.day2.i18n.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 */
public class Demo1Action extends ActionSupport {
    public String execute() {
        //编程式验证时，取消息资源文件的内容来作为提示信息
        System.out.println(getText("hello"));
        return "success";
    }
}
