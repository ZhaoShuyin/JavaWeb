package cn.struts.day1.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//实现特定的接口
//为何在动作方法执行前能把相应的对象注入进来，由一个叫做servletConfig的拦截器完成的
public class Servlet2Action extends ActionSupport implements ServletRequestAware, ServletContextAware {
    private HttpServletRequest request;
    private ServletContext servletContext;

    //获取ServletAPI
    public String m1() {
        System.out.println("==================================");
        System.out.println("Action : " + this);
        System.out.println("request : " + request);
        System.out.println("servletContext : " + servletContext);
        System.out.println("==================================");
        ActionContext context = ServletActionContext.getContext();
        return null;
    }

    //struts2框架会把当前的请求对象注入进来
    //该方法会在动作方法前执行
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    //struts2框架会把当前的ServletContext对象注入进来
    //该方法会在动作方法前执行
    public void setServletContext(ServletContext sc) {
        this.servletContext = sc;
    }



}
