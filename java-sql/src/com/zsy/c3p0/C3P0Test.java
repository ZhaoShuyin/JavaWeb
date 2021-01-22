package com.zsy.c3p0;

import java.sql.Connection;

public class C3P0Test {

	public static void main(String[] args) {
		System.out.println("C3P0Test");
		Connection conn = C3P0Util.getConnection();
		System.out.println(conn.getClass().getName());
	}

}