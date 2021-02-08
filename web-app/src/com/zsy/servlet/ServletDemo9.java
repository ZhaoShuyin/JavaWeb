package com.zsy.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取ServletContext对象
 * @author zhy
 *
 */
public class ServletDemo9 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取ServletContext
		ServletContext context = this.getServletContext();
		//2.输出ServletContext的hashCode
		System.out.println(context.hashCode());
		
		//获取全局初始化参数
		String value = context.getInitParameter("param1");
		System.out.println(value);
		
		//获取全局初始化参数名称的枚举
		Enumeration<String> names = context.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value1 = context.getInitParameter(name);
			System.out.println(name+","+value1);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
