package com.zsy.datasource.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * 对Connection的适配器进行包装
 * 1.创建一个类，继承适配器。
 * 2.定义一个变量，用于引用被包装对象。
 * 3.提供一个构造函数，用于接收被包装对象，同时把被包装对象传入适配器。保证适配器和包装类，包装的是同一个对象
 * 4.对于需要改写的方法，提供改写的代码。
 * @author zhy
 *
 */
public class MyConnection3 extends ConnectionAdapter {//第一步

	//第二步
	private Connection conn;//它是规范的接口，不是具体的实现类
	private List<Connection> pool;

	//第三步
	public MyConnection3(Connection conn, List<Connection> pool) {
		super(conn, pool);//第三步
		this.conn = conn;
		this.pool = pool;
	}


	public void close() throws SQLException {
		pool.add(conn);
	}



}
