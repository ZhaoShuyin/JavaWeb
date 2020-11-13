package dbcp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Title dbcp
 */

public class Test1 {

    private static QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());
    private static QueryRunner qr = new QueryRunner();

    public static void main(String[] args) {
        try {
            Object[] objects = queryRunner.query("show full processlist", new ArrayHandler());
            System.out.println(Arrays.toString(objects));
            Object query = queryRunner.query("select name from user where id =1", new ScalarHandler());
            System.out.println("Test1 "+query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
