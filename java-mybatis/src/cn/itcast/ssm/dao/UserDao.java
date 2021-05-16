package cn.itcast.ssm.dao;

import cn.itcast.ssm.po.User;

public interface UserDao {
	/**
	 * 更新用户信息
	 * @param user
	 * @throws Exception
	 */
	public void updateUserById(User user) throws Exception;
}
