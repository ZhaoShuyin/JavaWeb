package cn.struts.day5.service.impl;

import java.util.List;

import cn.struts.day5.dao.UserDao;
import cn.struts.day5.dao.impl.UserDaoImpl;
import cn.struts.day5.domain.User;
import cn.struts.day5.exception.IdIsNullException;
import cn.struts.day5.exception.UsernameExistException;
import cn.struts.day5.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	//登录查询
	public User login(String username, String password) {
		return userDao.findUser(username,password);
	}

	//查询列表
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	/**
	 * 保存User
	 */
	public void saveUser(User user) throws UsernameExistException {
		if(user==null){
			throw new IllegalArgumentException("要保存的参数user不能为null");
		}
		boolean exist = userDao.checkUsernameExist(user.getUsername());
		if(exist){
			throw new UsernameExistException("The username \""+user.getUsername()+"\" has exist,please change another!");
		}
		userDao.save(user);
	}

	/**
	 * 查询User
	 */
	public User findUserById(Integer userId) {
		return userDao.findUser(userId);
	}

	/**
	 * 更新User
	 */
	public void updateUser(User user) throws IdIsNullException {
		if(user==null)
			throw new IllegalArgumentException("要保存的参数user不能为null");
		if(user.getId()==null)
			throw new IdIsNullException("If you want to update user,please check your User object's id is null?");
		userDao.update(user);
	}

	/**
	 * 删除User
	 */
	public void deleteUser(Integer userId) {
		userDao.delete(userId);
	}

	/**
	 * 条件查询
	 * @param nickname 用户昵称 支持模糊查询。如果该参数为“”或null，表示忽略该条件
	 * @param gender 用户性别。如果该参数为“”或null，表示忽略该条件
	 * @param degrees 用户学历。如果该参数为“”或null，表示忽略该条件
	 * @param hasResume 字符串类型。t：有简历的，f：没有简历的 .如果该参数为“”或null，表示忽略该条件
	 * @return
	 */
	public List<User> findUser(String nickname, String gender, String degrees,String hasResume) {
		return userDao.findUser(nickname,gender,degrees,hasResume);
	}

}
