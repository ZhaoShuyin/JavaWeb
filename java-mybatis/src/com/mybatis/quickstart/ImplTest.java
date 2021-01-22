package com.mybatis.quickstart;

import com.mybatis.dao.UserDao;
import com.mybatis.dao.impl.UserDaoImpl;
import com.mybatis.po.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class ImplTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException{
		String resource = "MyBatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 1°¢sqlSessionFactoryªÒ»°
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testQueryUserById() throws Exception {

		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.queryUserById(1);
		System.err.println(user);
	}

}
