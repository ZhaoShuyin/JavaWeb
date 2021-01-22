package com.zsy.datasource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * 操作学生的数据持久层对象
 */
public class StudentDao {

    //为了提高执行效率，以后再想使用我的类，必须给我一个数据源
    private DataSource ds;//必须是规范类型的

    //在构造函数中，传入一个数据源
    public StudentDao(DataSource ds) {
        this.ds = ds;
    }

    /**
     * 获取总记录条数
     *
     * @return
     */
    public int findTotalRecords() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int totalrecords = 0;
        try {
            //1.拿连接需要从池里面获取
            conn = ds.getConnection();
            //2.获取操作SQL语句的对象
            pstm = conn.prepareStatement("select count(*) from student ");
            //3.执行SQL语句
            rs = pstm.executeQuery();
            //4.判断有没有结果集
            if (rs.next()) {
                totalrecords = rs.getInt(1);
            }
            return totalrecords;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();//把连接关了，而不是把用完的连接还回池中。
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
