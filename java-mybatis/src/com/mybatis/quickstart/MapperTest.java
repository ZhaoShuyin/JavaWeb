package com.mybatis.quickstart;

import com.mybatis.mapper.UserMapper;
import com.mybatis.po.User;
import com.mybatis.po.UserCustom;
import com.mybatis.po.UserQuery;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用动态代理
 */
public class MapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException{
		String resource = "MyBatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 1、sqlSessionFactory获取
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testQueryUserById() throws Exception {
		// 获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(userMapper);
		User user = userMapper.queryUserById(1);
		System.out.println(user);
	}


	@Test
	public void testQueryUserByUserName() throws Exception {
		// 获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuery userQuery = new UserQuery();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("明");
		userQuery.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.queryUserByUserName(userQuery);
		System.out.println(list);
	}

	@Test
	public void testQueryUserByMap() throws Exception {
		// 获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuery userQuery = new UserQuery();
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", "1");
		userQuery.setMap(map);
		UserCustom userCustom = userMapper.queryUserByMap(userQuery);
		System.out.println(userCustom);
	}

	@Test
	public void testQueryUsers() throws Exception {
		// 获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int count = userMapper.queryUsers();
		System.out.println(count);
	}

	@Test
	public void testQueryUserByConditions() throws Exception {
		// 获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuery userQuery = new UserQuery();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("明");
		userQuery.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.queryUserByConditions(userQuery);
		System.out.println(list);
	}

	@Test
	public void testQueryUserByList() throws Exception {
		// 获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 获取代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuery userQuery = new UserQuery();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(6);
		ids.add(10);
		userQuery.setIds(ids);
		List<UserCustom> list = userMapper.queryUserByList(userQuery);
		System.out.println(list);
	}

}
