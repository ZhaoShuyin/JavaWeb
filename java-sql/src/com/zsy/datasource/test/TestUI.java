package com.zsy.datasource.test;

import com.zsy.datasource.dao.StudentDao;
import com.zsy.datasource.datasource.MyDataSource;

public class TestUI {

	public static void main(String[] args) {
		MyDataSource ds = new MyDataSource();
		System.out.println("在执行Dao的方法前："+ds.getSize());
		//在实例化学生的持久层对象时，必须传入一个数据源
		StudentDao dao = new StudentDao(ds);
		//执行方法
		int res = dao.findTotalRecords();
		System.out.println(res);

		System.out.println("在执行Dao的方法后："+ds.getSize());
	}

}
