//package cn.itcast.datasource;
//
//import java.sql.Array;
//import java.sql.Blob;
//import java.sql.Clob;
//import java.sql.NClob;
//import java.sql.SQLClientInfoException;
//import java.sql.SQLException;
//import java.sql.SQLXML;
//import java.sql.Struct;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.Executor;
//
//import com.mysql.jdbc.Connection;
/**
 * 继承这条路根本行不通，原因：
 * 	1.MySql的Connection的构造函数是默认的访问修饰符，只能在包内可见。
 * 	2.就算是放到同一个包下，也不能使用，因为虽然close方法被重写了，可以实现还回池中。但是其他的方法都不能用了。
 */
//public class MyConnection1 extends Connection {
//	
//	MyConnection1(String arg0, int arg1, Properties arg2, String arg3,
//			String arg4) throws SQLException {
//		super(arg0, arg1, arg2, arg3, arg4);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Clob createClob() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Blob createBlob() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public NClob createNClob() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public SQLXML createSQLXML() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isValid(int timeout) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void setClientInfo(String name, String value)
//			throws SQLClientInfoException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void setClientInfo(Properties properties)
//			throws SQLClientInfoException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public String getClientInfo(String name) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Properties getClientInfo() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Array createArrayOf(String typeName, Object[] elements)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Struct createStruct(String typeName, Object[] attributes)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setSchema(String schema) throws SQLException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public String getSchema() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void abort(Executor executor) throws SQLException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void setNetworkTimeout(Executor executor, int milliseconds)
//			throws SQLException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public int getNetworkTimeout() throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public <T> T unwrap(Class<T> iface) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isWrapperFor(Class<?> iface) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
