package cn.struts.day5.dao;

import java.util.List;

import cn.struts.day5.domain.User;

public interface UserDao {
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return 没有返回null
	 */
	User findUser(String username, String password);
	/**
	 * 查询所有用户
	 * @return List
	 */
	List<User> findAllUsers();
	/**
	 * 根据用户名检查用户是否存在
	 * @param username
	 * @return 存在返回true
	 */
	boolean checkUsernameExist(String username);
	/**
	 * 保存用户信息
	 * @param user
	 */
	void save(User user);
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return 不存在返回null
	 */
	User findUser(Integer userId);
	/**
	 * 更新用户信息
	 * @param user
	 */
	void update(User user);
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	void delete(Integer userId);
	/**
	 * 按照条件查询
	 * @param nickname
	 * @param gender
	 * @param degrees
	 * @param hasResume
	 * @return
	 */
	List<User> findUser(String nickname, String gender, String degrees,
                        String hasResume);

}
