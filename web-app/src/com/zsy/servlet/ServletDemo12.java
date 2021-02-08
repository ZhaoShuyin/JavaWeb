package com.zsy.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取文件的绝对路径
 * @author zhy
 *
 */
public class ServletDemo12 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取到ServletContext对象
		ServletContext context = this.getServletContext();
		//2.获取文件的绝对路径
		String path = context.getRealPath("/7.jpg");//在web应用中，路径如果表示当前应用，通常会用/
		System.out.println(path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
