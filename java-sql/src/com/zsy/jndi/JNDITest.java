package com.zsy.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDITest {
	
	/**
	 * 获取不到任何内容，因为他没有经过Tomcat服务器
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args)throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");//"java:comp/env"它就是存在于jndi容器中，数据源的路径。
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/dbcp");//"jdbc/dbcp"它是数据源的名称
		System.out.println(dataSource.getConnection().getClass().getName());
	}

}