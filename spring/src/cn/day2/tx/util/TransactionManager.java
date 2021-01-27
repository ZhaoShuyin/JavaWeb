package cn.day2.tx.util;

import java.sql.Connection;
import java.sql.SQLException;
//import cn.day2.tx2.util.C3P0Util;

//公用代码
public class TransactionManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        Connection conn = tl.get();//从当前线程上获取连接
        if (conn == null) {
            conn = C3P0Util.getConnection();
            tl.set(conn);//绑到当前线程上
        }
        System.out.println(" ============== < " + Thread.currentThread().getId() + " >  获取连接  { " + conn+" }");
        return conn;
    }

    public static void startTransaction() {
        System.out.println(" ============== 开启事务");
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit() {
        System.out.println(" ==============提交事务");
        Connection conn = getConnection();
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {
        System.out.println(" ==============回滚事务");
        Connection conn = getConnection();
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        System.out.println(" ==============释放资源");
        Connection conn = getConnection();
        try {
            conn.close();
            tl.remove();//从当前线程上删除掉
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
