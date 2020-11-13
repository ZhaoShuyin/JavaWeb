package dbcp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @Title dbcp
 */

public class Test2 {

    private static QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());
    private static QueryRunner qr = new QueryRunner();

    public static void main(String[] args) {
        try {
            Object query = queryRunner.query("select name from user where id =2", new ScalarHandler());
            System.out.println("Test2 "+query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
