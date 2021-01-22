package com.zsy.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {

    //1.定义一个c3p0数据源
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    //2.使用静态代码块，初始化数据源 //自动读取c3p0-config.xml文件
//	static{
//		try {
//			ds.setDriverClass("com.mysql.jdbc.Driver");
//			ds.setJdbcUrl( "jdbc:mysql://localhost:3306/dbcp" );
//			ds.setUser("root");
//			ds.setPassword("123456");
//		} catch (PropertyVetoException e) {
//			throw new ExceptionInInitializerError("初始化连接池失败!");
//		}
//	}

    //3.提供一个获取数据源的方法
    public static DataSource getDataSource() {
        return ds;
    }

    //4.提供一个获取连接的方法，注意，以后获取连接，必须使用该方法
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
