package com.zsy.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * HttpServlet的执行过程和原理分析
 * @author zhy
 *
 */
public class ServletDemo2 extends HttpServlet {

	/**
	 * 我们在编写Servlet时，选择继承HttpServlet。直接访问时会产生一个看上去的错误。
	 * 【HTTP Status 405 - HTTP method GET is not supported by this URL】
	 * 
	 * 原因：
	 * 	HttpServlet的执行过程:
	 * 		首先执行的是service方法,是HttpServlet重写GenericServlet的service方法。
	 * 		接下来HttpServlet自己的service方法执行。根据不同的请求方式，调用不同方法。（设计模式-模板方法设计模式）
	 * 		doGet方法正常的执行了。
	 * 目的：
	 * 	让我们重写doGet和doPost方法。不要重写service方法，两个都是。
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("hello HttpServlet ");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
		
	
	
}
