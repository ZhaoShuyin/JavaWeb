package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

/**
 * user dao
 * @author Mr.Wang
 */
public interface UserDao {

	/**
	 * �����û�id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(int id) throws Exception;
}
