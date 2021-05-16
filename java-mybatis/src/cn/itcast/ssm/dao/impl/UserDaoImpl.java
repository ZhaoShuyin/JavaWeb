package cn.itcast.ssm.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.po.User;

/**
 * 接口实现类
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public void updateUserById(User user) throws Exception {
		this.getSqlSession().update("test.updateUserById", user);
	}

}
