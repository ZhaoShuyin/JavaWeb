package cn.itcast.mybatis.quickstart;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import cn.itcast.mybatis.po.User;

public class QuickStartTest {

	/**
	 * 根据ID查询用户信息
	 * @throws IOException 
	 */
	@Test
	public void testQueryUserById() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1、sqlSessionFactory获取
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2、获取回话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3、api调用
		/**
		 * arg0:namespace+"."+id
		 * arg1:参数
		 */
		User user = sqlSession.selectOne("test.queryUserById", 1);
		System.out.println(user);
		
	}
	
	/**
	 * 根据username查询用户信息
	 * @throws IOException
	 */
	@Test
	public void testQueryUserByUserName() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1、sqlSessionFactory获取
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2、获取回话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3、api调用
		List<User> list = sqlSession.selectList("test.queryUserByUserName", "明");
		System.out.println(list);
		
	}
	
	/**
	 * 根据username查询用户信息
	 * @throws IOException
	 */
	@Test
	public void testInsertUser() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1、sqlSessionFactory获取
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2、获取回话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3、api调用
		User user = new User();
		user.setUsername("tom");
		user.setAddress("上海");
		user.setBirthday(new Date());
		user.setSex("0");
		sqlSession.insert("test.insertUser", user);
		
		// 提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	/**
	 * 返回自增主键id
	 * @throws IOException
	 */
	@Test
	public void testInsertUserReturnId() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1、sqlSessionFactory获取
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2、获取回话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3、api调用
		User user = new User();
		user.setUsername("tom11");
		user.setAddress("上海11");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlSession.insert("test.insertUserReturnId", user);
		System.out.println(user.getId());
		// 提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	/**
	 * 更新用户
	 * @throws IOException
	 */
	@Test
	public void testUpdateUserById() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1、sqlSessionFactory获取
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2、获取回话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3、api调用
		User user = new User();
		user.setUsername("tom22");
		user.setAddress("上海22");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setId(29);
		sqlSession.update("test.updateUserById", user);
		// 提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	/**
	 * 删除用户
	 * @throws IOException
	 */
	@Test
	public void testDeleteUserById() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1、sqlSessionFactory获取
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2、获取回话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3、api调用
		sqlSession.delete("test.deleteUserById", 28);
		// 提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
}
