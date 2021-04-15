package cn.struts.day5.service;

import java.util.List;

import cn.struts.day5.domain.User;
import cn.struts.day5.exception.IdIsNullException;
import cn.struts.day5.exception.UsernameExistException;
//要把注释写清楚，做到没有异议
public interface UserService {
	/**
	 * 用户登陆
	 * @param username 用户名
	 * @param password 密码
	 * @return 如果用户名或密码错误，返回null，否则返回user对象
	 */
	User login(String username, String password);
	/**
	 * 查询所有用户
	 * @return List<User>
	 */
	List<User> findAllUsers();
	/**
	 * 保存用户
	 * @param user
	 * @throws UsernameExistException 如果保存的用户名存在了，抛出此异常
	 */
	void saveUser(User user) throws UsernameExistException;
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return 没找到返回null，否则返回user对象
	 */
	User findUserById(Integer userId);
	/**
	 * 修改用户信息
	 * @param user
	 * @throws IdIsNullException 如果参数user的id为null，抛出此异常
	 */
	void updateUser(User user) throws IdIsNullException;
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	void deleteUser(Integer userId);
	/**
	 * 按照条件查询用户信息。多个条件不为“”或null时，做与(and)运算
	 * @param nickname 用户昵称 支持模糊查询。如果该参数为“”或null，表示忽略该条件
	 * @param gender 用户性别。如果该参数为“”或null，表示忽略该条件
	 * @param degrees 用户学历。如果该参数为“”或null，表示忽略该条件
	 * @param hasResume 字符串类型。t：有简历的，f：没有简历的 .如果该参数为“”或null，表示忽略该条件
	 * @return 查询的结果
	 */
	List<User> findUser(String nickname, String gender, String degrees, String hasResume);
}
