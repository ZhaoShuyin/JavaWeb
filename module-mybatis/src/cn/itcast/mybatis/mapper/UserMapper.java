package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public interface UserMapper {

	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(int id) throws Exception;
	
	
	public List<UserCustom> queryUserByUserName(UserQueryVo userQueryVo) throws Exception;
	
	public UserCustom queryUserByMap(UserQueryVo userQueryVo) throws Exception;
	
	public int queryUsers() throws Exception;
	
	public List<UserCustom> queryUserByConditions(UserQueryVo userQueryVo) throws Exception;
	
	public List<UserCustom> queryUserByList(UserQueryVo userQueryVo) throws Exception;
}
