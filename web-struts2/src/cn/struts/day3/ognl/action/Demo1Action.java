package cn.struts.day3.ognl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class Demo1Action extends ActionSupport {

    /**
     *
     */
    private StrutsPrepareAndExecuteFilter executeFilter;


    private ValueStack valueStack;

    public Demo1Action() {
        System.out.println("调用了动作类的构造方法");
    }

    public String execute() {
        return null;
    }
}
