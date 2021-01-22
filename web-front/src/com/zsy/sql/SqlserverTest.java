package com.zsy.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlserverTest {
    public static void main(String[] args) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zsydb";
        String userName = "zsy";
        String userPwd = "123456";
        try {
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {
            Connection connection = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功！");

            String sql = "select * from yonghu";  //查询关键代码
            PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
    }

}