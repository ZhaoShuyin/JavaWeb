package cn.struts.day5.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static DataSource getDataSource(){
		return dataSource;
	}
}
