package com.mybatis.dao;


import com.mybatis.po.User;

/**
 * 使用接口定义方法
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
