package com.zsy.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletContext对象
 * @author zhy
 *
 */
public class ServletDemo8 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取ServletConfig对象
		ServletConfig config = this.getServletConfig();
		//2.使用config对象来获取ServletContext
		ServletContext context = config.getServletContext();
		//3.输出context对象的hashCode
		System.out.println(context.hashCode());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
