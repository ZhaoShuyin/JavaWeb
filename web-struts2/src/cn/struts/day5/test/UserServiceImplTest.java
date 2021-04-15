package cn.struts.day5.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.struts.day5.domain.User;
import cn.struts.day5.exception.IdIsNullException;
import cn.struts.day5.exception.UsernameExistException;
import cn.struts.day5.service.UserService;
import cn.struts.day5.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	private UserService s = new UserServiceImpl();
	@Test
	public void testLogin() {
		User user = s.login("admin", "123");
		assertNotNull(user);// 断言不应该为null
		user = s.login("adminstrator", "123");
		assertNull(user);
		user = s.login("admin", "1234");
		assertNull(user);
		user = s.login("adminstrator", "1234");
		assertNull(user);
	}

	@Test
	public void testFindAllUsers() {
		List<User> users = s.findAllUsers();
		assertEquals(1, users.size());
		assertNotNull(users.get(0));
	}

	@Test
	public void testSaveUser() throws UsernameExistException {
		User user = new User();
		user.setUsername("cc");
		user.setPassword("123");
		user.setNickname("陈涔");
		user.setGender("female");
		s.saveUser(user);
	}
	//测试发生异常
	@Test(expected=UsernameExistException.class)
	public void testSaveUser1() throws UsernameExistException {
		User user = new User();
		user.setUsername("cc");
		user.setPassword("123");
		user.setNickname("陈涔");
		user.setGender("female");
		s.saveUser(user);
	}
	@Test
	public void testFindUserById() {
		User user = s.findUserById(1);
		assertNotNull(user);
		user = s.findUserById(8888);
		assertNull(user);
	}

	@Test
	public void testUpdateUser() throws IdIsNullException {
		User user = s.findUserById(1);
		user.setNickname("超级管理员");
		s.updateUser(user);
	}
	//测试发生异常
	@Test(expected=IdIsNullException.class)
	public void testUpdateUser1() throws IdIsNullException {
		User user = new User();
		user.setNickname("超级管理员");
		s.updateUser(user);
	}
	@Test
	public void testDeleteUser() {
		s.deleteUser(2);
	}

}
