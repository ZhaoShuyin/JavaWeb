package com.zsy.datasource.connectionpool;

import com.zsy.datasource.utils.JdbcUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据库连接池
 */
public class ConnectionPoolDemo {

	//准备一个容器，作为池来存放连接
	private static List<Connection> pool = new ArrayList<Connection>();

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

	//以后再获取连接的时候，必须使用这个方法
	public synchronized static Connection getConnection(){//拿连接的方法必须保证是同步的
		if(pool.size()>0){
			return pool.remove(0);//先进先出
		}else{
			throw new RuntimeException("服务器真忙！");
		}
	}

	//还回池中，其实就是追加到连接池集合的末尾
	public static void release(Connection conn){
		pool.add(conn);
	}

}
