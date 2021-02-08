package com.zsy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet的生命周期
 * 1:Servlet创建
 * 2:Servlet初始化
 * 3:Servlet调用
 * 3:Servlet调用
 * 3:Servlet调用
 * 4:Servlet回收
 */
public class ServletDemo3 extends HttpServlet {

    //实例化方法
    public ServletDemo3() {
        System.out.println("Servlet创建");
    }

    //初始化方法
    public void init() {
        System.out.println("Servlet初始化");
    }

    //提供服务的方法
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet调用");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    //销毁方法
    public void destroy() {
        System.out.println("Servlet回收");
    }
}
