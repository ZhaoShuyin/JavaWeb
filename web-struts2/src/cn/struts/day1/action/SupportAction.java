package cn.struts.day1.action;

import com.opensymphony.xwork2.ActionSupport;

//推荐的：
//理由：支持验证功能；支持国际化；

/**
 * ActionSupport
 */
public class SupportAction extends ActionSupport {

    public String execute() throws Exception {
        System.out.println("Action =================== Support...");
        return SUCCESS;
    }

    public String save() {
        System.out.println("Action =================== Support save().....");
        return null;
    }

    public String update() {
        System.out.println("Action ========= ========== Support update().....");
        return null;
    }
}
