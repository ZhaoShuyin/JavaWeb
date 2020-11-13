package dbcp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @Title dbcp
 */

public class Test {

    private static QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());
    private static QueryRunner qr = new QueryRunner();

    public static void main(String[] args) {

        try {
//            DataSource dataSource = queryRunner.getDataSource();
//            Connection connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            try {
                Connection connection = DBCPUtil.getConnection();
                Object query = qr.query(
                        connection,
                        "select name from user where id =1",
                        new ScalarHandler());
                connection.close();
                System.out.println(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Test3() {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    QueryRunner qr = new QueryRunner();
                    try {
                        Connection connection = ThreadManager.getConnection();
                        ThreadManager.startTransaction();
                        int update = qr.update(connection, "insert data values(" + System.currentTimeMillis() + " )");
                        String name = Thread.currentThread().getName();
                        int conName = System.identityHashCode(connection);
                        System.out.println("线程 : " + name + " 使用 连接 : " + conName + " 结果 :" + update);
//                        String x = name + "     (" + conName + ")           insert : " + update + "\n             " + connection.toString();
//                        System.out.println(x);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        ThreadManager.release();
                    }
                }
            });
            thread.setName("第<" + i + ">个线程");
            thread.start();
        }
    }


    public static void Test1() {
        for (int i = 0; i < 100; i++) {
            QueryRunner qr = new QueryRunner();
            try {
                Connection connection = DBCPUtil.getConnection();
                Object query = qr.query(
                        connection,
                        "select name from user where id =1",
                        new ScalarHandler());
//                connection.close(); //不还回池中则一直新建连接
                System.out.println("Test1 " + query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Test2() {
        for (int i = 0; i < 100; i++) {
            QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
            try {
                Object query = qr.query(
                        "select name from user where id =1",
                        new ScalarHandler());
                System.out.println("Test1 " + query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
