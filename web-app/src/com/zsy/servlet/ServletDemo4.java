package com.zsy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 线程安全问题：
 * 	Servlet不是线程安全的
 * @author zhy
 *
 */
public class ServletDemo4 extends HttpServlet {

	//定义一个变量，用于初始化每个用户看书的页码
	private int page = 1;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("欢迎看书，您看的是第"+page+"页");
		//page++;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
