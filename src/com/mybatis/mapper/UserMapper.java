package com.mybatis.mapper;

import java.util.List;

import com.mybatis.po.User;
import com.mybatis.po.UserCustom;
import com.mybatis.po.UserQuery;

/**
 * 代理
 */
public interface UserMapper {

	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(int id) throws Exception;

	public List<UserCustom> queryUserByUserName(UserQuery userQuery) throws Exception;

	public UserCustom queryUserByMap(UserQuery userQuery) throws Exception;

	public int queryUsers() throws Exception;

	public List<UserCustom> queryUserByConditions(UserQuery userQuery) throws Exception;

	public List<UserCustom> queryUserByList(UserQuery userQuery) throws Exception;
}
