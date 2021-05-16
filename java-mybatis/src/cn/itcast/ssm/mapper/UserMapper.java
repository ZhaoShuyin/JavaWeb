package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.User;

public interface UserMapper {

	/**
	 * 更新用户信息
	 * @param user
	 * @throws Exception
	 */
	public void updateUserById(User user) throws Exception;
}
