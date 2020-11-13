package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc工具类：
 * 		1.获取连接
 * 		2.释放资源
 * @author zhy
 *
 */
public class JdbcUtil {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/dbcp?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
	private static String user ="root";
	private static String password = "IW*ueQQjkl";

	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 */
	public static Connection getConnection() throws Exception{
		Connection conn = DriverManager.getConnection(url,user,password);
		//conn.setTransactionIsolation(Connection.TRANSACTION_NONE);            //1,最低级别
		//conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);//2,低级别
		//conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);  //3. 中级别
		//conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ); //4.高级别(默认)
		//conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);    //5.最高界别
		return conn;
	}

	/**
	 * 释放资源
	 */
	public static void release(ResultSet rs,Statement st,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
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
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from user");
		while(resultSet.next()){
			System.out.println(resultSet.getString(2));
		}
	}
}
