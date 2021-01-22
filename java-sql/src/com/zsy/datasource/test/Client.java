package com.zsy.datasource.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zsy.datasource.utils.JdbcUtil;

public class Client {


	public static void main(String[] args) throws Exception {
		long startConn = System.currentTimeMillis();
		Connection conn = JdbcUtil.getConnection();//这步是最耗时间的
		long executeConn = System.currentTimeMillis()-startConn;
		System.out.println(executeConn);


		long startSt = System.currentTimeMillis();
		PreparedStatement pstm = conn.prepareStatement("select * from student ");
		long executeSt = System.currentTimeMillis()-startSt;
		System.out.println(executeSt);


		long startRs = System.currentTimeMillis();
		ResultSet rs = pstm.executeQuery();
		long executeRs = System.currentTimeMillis()-startRs;
		System.out.println(executeRs);


		long startWhile =System.currentTimeMillis();
		while(rs.next());
		long executeWhile = System.currentTimeMillis()-startWhile;
		System.out.println(executeWhile);

	}

}
