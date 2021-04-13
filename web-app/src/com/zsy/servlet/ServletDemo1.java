package com.zsy.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 使用MyEclipse创建Servlet
 * @author zhy
 *
 */
public class ServletDemo1 extends GenericServlet {

	/**
	 * 第一步：编写一个普通类，继承GenericServlet。
	 * 第二步：编译。
	 * 第三步：配置。
	 * 	<servlet>
 		<servlet-name>ServletDemo1</servlet-name>
 		<servlet-class>cn.struts.day2.regist.servlet</servlet-class>
	 	</servlet>
	 	<servlet-mapping>
	 		<servlet-name>ServletDemo1</servlet-name>
	 		<url-pattern>/ServletDemo1</url-pattern>
	 	</servlet-mapping>
	 	第四步:部署。把应用发布到tomcat服务器中。
	 */
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("hello ServletDemo1");

	}

}