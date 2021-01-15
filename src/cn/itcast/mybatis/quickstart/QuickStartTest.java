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
	 * ����ID��ѯ�û���Ϣ
	 * @throws IOException 
	 */
	@Test
	public void testQueryUserById() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1��sqlSessionFactory��ȡ
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2����ȡ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3��api����
		/**
		 * arg0:namespace+"."+id
		 * arg1:����
		 */
		User user = sqlSession.selectOne("test.queryUserById", 1);
		System.out.println(user);
		
	}
	
	/**
	 * ����username��ѯ�û���Ϣ
	 * @throws IOException
	 */
	@Test
	public void testQueryUserByUserName() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1��sqlSessionFactory��ȡ
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2����ȡ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3��api����
		List<User> list = sqlSession.selectList("test.queryUserByUserName", "��");
		System.out.println(list);
		
	}
	
	/**
	 * ����username��ѯ�û���Ϣ
	 * @throws IOException
	 */
	@Test
	public void testInsertUser() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1��sqlSessionFactory��ȡ
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2����ȡ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3��api����
		User user = new User();
		user.setUsername("tom");
		user.setAddress("�Ϻ�");
		user.setBirthday(new Date());
		user.setSex("0");
		sqlSession.insert("test.insertUser", user);
		
		// �ύ����
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	/**
	 * ������������id
	 * @throws IOException
	 */
	@Test
	public void testInsertUserReturnId() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1��sqlSessionFactory��ȡ
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2����ȡ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3��api����
		User user = new User();
		user.setUsername("tom11");
		user.setAddress("�Ϻ�11");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlSession.insert("test.insertUserReturnId", user);
		System.out.println(user.getId());
		// �ύ����
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	/**
	 * �����û�
	 * @throws IOException
	 */
	@Test
	public void testUpdateUserById() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1��sqlSessionFactory��ȡ
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2����ȡ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3��api����
		User user = new User();
		user.setUsername("tom22");
		user.setAddress("�Ϻ�22");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setId(29);
		sqlSession.update("test.updateUserById", user);
		// �ύ����
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	/**
	 * ɾ���û�
	 * @throws IOException
	 */
	@Test
	public void testDeleteUserById() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 1��sqlSessionFactory��ȡ
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		
		// 2����ȡ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 3��api����
		sqlSession.delete("test.deleteUserById", 28);
		// �ύ����
		sqlSession.commit();
		
		sqlSession.close();
	}
}
