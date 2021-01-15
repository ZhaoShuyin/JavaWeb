package com.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 与事务相关的工具类
 */
public class ThreadManager {

    //1.定一个线程局部变量，用于存放当前线程的连接
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    //2.定义一个方法，获取一个连接，放入到线程局部变量中
    //注意：以后再拿连接，必须使用这个方法， 不能使用DBCPUtil的getConnection(),也不能使用DBCPUtil.getDataSource().getConnection()
    public static Connection getConnection() {
        //从当前线程的局部变量中获取一个连接
        Connection conn = tl.get();
        //判断有没有
        if (conn == null) {//没有
            conn = DBCPUtil.getConnection();//
            tl.set(conn);//把连接放入线程局部变量中。相当于在当前线程上绑定了一个连接。
        }
        return conn;
    }


    //3.开启事务
    public static void startTransaction() {
        //从线程局部变量中获取一个连接。相当于获取绑定在当前线程上的连接
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //4.事务提交
    public static void commit() {
        //从线程局部变量中获取一个连接。相当于获取绑定在当前线程上的连接
        try {
            getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //5.事务回滚
    public static void rollback() {
        //从线程局部变量中获取一个连接。相当于获取绑定在当前线程上的连接
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //6.释放资源
    public static void release() {
        //从线程局部变量中获取一个连接。相当于获取绑定在当前线程上的连接
        try {
            getConnection().close();//还回池中
            tl.remove();//把当前连接和当前线程解绑。原因：服务器在线程上使用的是线程池，并不是真正的线程结束。所以我们需要解绑操作
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
