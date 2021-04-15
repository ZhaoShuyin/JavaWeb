package cn.struts.day5.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.struts.day5.util.C3P0Util;

public class JdbcDaoSupport {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params){
		try {
			return qr.query(sql, rsh, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int update(String sql, Object... params){
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int[] batch(String sql, Object[][] params){
		try {
			return qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
