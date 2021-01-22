package com.zsy.datasource.datasource;

import com.zsy.datasource.utils.JdbcUtil;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 实现规范数据源的接口的实现类
 * @author zhy
 *
 */
public class MyDataSource implements DataSource {

	//准备一个容器，作为池来存放连接
	private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());//把不同步的转成同步的。 当做增量时，它扩充原来长度的一半
	//private static List<Connection> pool1 = new Vector<Connection>();//它本身就是线程安全的。 当做增量时，它扩充原来长度的一倍

	//使用静态代码块，给池加入连接
	static{
		try {
			for(int i=0;i<10;i++){
				Connection conn = JdbcUtil.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//这个方法，是为了提高大家理解而加上去的，实际开发中根本不需要此方法。
	public int getSize(){
		return pool.size();
	}

	//使用动态代理的方式，实现连接的还回池中
	public Connection getConnection() throws SQLException {
		if(pool.size()>0){
			final Connection conn =  pool.remove(0);//先进先出
			Connection proxyConn = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(),
					conn.getClass().getInterfaces(),
					new InvocationHandler() {
						//如何代理:判断当前方法是不是close，是的话还回池中，不是的话，调用对象原来的方法
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							if("close".equals(method.getName())){
								//还回池中
								return pool.add(conn);
							}else{
								//调用对象原来的方法
								return method.invoke(conn, args);
							}
						}
					});
			return proxyConn;
		}else{
			throw new RuntimeException("服务器真忙！");
		}
	}




	//使用适配器模式，对Connection进行包装,实现还回池中
//	public Connection getConnection() throws SQLException {
//		if(pool.size()>0){
//			Connection conn =  pool.remove(0);//先进先出
//			//使用MyConnection2进行对conn的包装
//			MyConnection3 myconn = new MyConnection3(conn,pool);
//			return myconn;
//		}else{
//			throw new RuntimeException("服务器真忙！");
//		}
//	}


	//使用包装模式，对Connection进行一次包装，实现连接的还回池中
//	public Connection getConnection() throws SQLException {
//		if(pool.size()>0){
//			Connection conn =  pool.remove(0);//先进先出
//			//使用MyConnection2进行对conn的包装
//			MyConnection2 myconn = new MyConnection2(conn,pool);
//			return myconn;
//		}else{
//			throw new RuntimeException("服务器真忙！");
//		}
//	}



	//获取连接  它不能实现把连接还回池中，不能使用
//	public Connection getConnection() throws SQLException {
//		if(pool.size()>0){
//			return pool.remove(0);//先进先出
//		}else{
//			throw new RuntimeException("服务器真忙！");
//		}
//	}
















	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {

	}


	public void setLoginTimeout(int seconds) throws SQLException {

	}


	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		return null;
	}

}
