package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

/**
 * user dao
 * @author Mr.Wang
 */
public interface UserDao {

	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(int id) throws Exception;
}
