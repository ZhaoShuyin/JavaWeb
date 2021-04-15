package cn.struts.day5.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import cn.struts.day5.dao.UserDao;
import cn.struts.day5.domain.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	//登录查询
	public User findUser(String username, String password) {
		return query("select * from T_USERS where username=? and password=?", 
					new BeanHandler<User>(User.class),
					username,password);
	}

	//查询列表
	public List<User> findAllUsers() {
		return query("select * from T_USERS", new BeanListHandler<User>(User.class));
	}

	public boolean checkUsernameExist(String username) {
		return query("select * from T_USERS where username=?", 
					new BeanHandler<User>(User.class),
					username)==null?false:true;
	}

	public void save(User user) {
		update("insert into T_USERS (username,password,nickname,gender,birthday,degrees,phonenum,hobby,path,filename,description) values (?,?,?,?,?,?,?,?,?,?,?)", 
				user.getUsername(),user.getPassword(),user.getNickname(),user.getGender(),
				user.getBirthday(),user.getDegrees(),user.getPhonenum(),user.getHobby(),
				user.getPath(),user.getFilename(),user.getDescription());
	}

	public User findUser(Integer userId) {
		return query("select * from T_USERS where id=?", 
				new BeanHandler<User>(User.class),
				userId);
	}

	public void update(User user) {
		update("update T_USERS set username=?,password=?,nickname=?,gender=?,birthday=?,degrees=?,phonenum=?,hobby=?,path=?,filename=?,description=? where id=?", 
				user.getUsername(),user.getPassword(),user.getNickname(),user.getGender(),
				user.getBirthday(),user.getDegrees(),user.getPhonenum(),user.getHobby(),
				user.getPath(),user.getFilename(),user.getDescription(),user.getId());
	}

	public void delete(Integer userId) {
		update("delete from T_USERS where id=?", userId);
	}

	public List<User> findUser(String nickname, String gender, String degrees,
			String hasResume) {
		StringBuffer sql = new StringBuffer("select * from T_USERS where 1=1");
		List<Object> params = new ArrayList<Object>(0);
		if(StringUtils.isNotBlank(nickname)){
			sql.append(" and nickname like ?");
			params.add("%"+nickname+"%");
		}
		if(StringUtils.isNotBlank(gender)){
			sql.append(" and gender=?");
			params.add(gender);
		}
		if(StringUtils.isNotBlank(degrees)){
			sql.append(" and degrees=?");
			params.add(degrees);
		}
		if(StringUtils.isNotBlank(hasResume)){
			if("t".equals(hasResume)){
				sql.append(" and filename is not null");
			}else if("f".equals(hasResume)){
				sql.append(" and filename is null");
			}
		}
		return query(sql.toString(), new BeanListHandler<User>(User.class), params.toArray());
	}

}
