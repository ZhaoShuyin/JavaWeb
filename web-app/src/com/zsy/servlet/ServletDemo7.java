package com.zsy.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletConfig对象
 * @author zhy
 *
 */
public class ServletDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取初始化参数
		 */
		//1.获取ServletConfig对象
		ServletConfig config = getServletConfig();
		//2.根据初始化参数的名称获取值
		String value = config.getInitParameter("encoding2");
		System.out.println(value);
	
		//获取初始化参数名称的枚举
		Enumeration<String> names = config.getInitParameterNames();
		//遍历枚举
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value1 = config.getInitParameter(name);
			System.out.println(name+","+value1);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
