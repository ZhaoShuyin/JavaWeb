package cn.itcast.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.po.User;

public class UserDaoImpl implements UserDao {

	/**
	 * 注入 sqlSessionFactory 构造方法
	 */
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User queryUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.queryUserById", id);
		return user;
	}

}
