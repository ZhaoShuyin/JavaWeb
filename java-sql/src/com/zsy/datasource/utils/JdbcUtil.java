package com.zsy.datasource.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * jdbc工具类：
 * 1.获取连接
 * 2.释放资源
 */
public class JdbcUtil {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");
        driver = bundle.getString("DRIVER");
        url = bundle.getString("URL");
        user = bundle.getString("USER");
        password = bundle.getString("PASSWORD");
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws Exception {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 释放资源
     */
    public static void release(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();
        System.out.println(conn.getClass().getName());
    }
}

