package cn.struts.day1.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Servlet1Action extends ActionSupport {

    //获取ServletAPI
    public String m1() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        ServletContext servletContext = ServletActionContext.getServletContext();
        System.out.println(" Servlet ============= request: " + request);
        System.out.println(" Servlet ============= session: " + session);
        System.out.println(" Servlet ============= servletContext : " + servletContext);
        return null;
    }
}
