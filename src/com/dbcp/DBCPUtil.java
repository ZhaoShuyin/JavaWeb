package com.dbcp;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * DBCP工具类
 */
public class DBCPUtil {

    //1定义一个数据源
    private static DataSource ds;

    //2
    static {
        try {
            Properties properties = new Properties();
            InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
            properties.load(in);
            ds = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println(e.toString());
           throw new ExceptionInInitializerError("初始化连接错误");
        }
    }

    //3get方法
    public static DataSource getDataSource() {
        return ds;
    }

    //获取连接
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
