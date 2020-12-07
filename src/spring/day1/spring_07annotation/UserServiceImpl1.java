package spring.day1.spring_07annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("userService1")
public class UserServiceImpl1 implements UserService {
	@Autowired
	@Qualifier("userDao")
	private UserDaoImpl userDao;
	/* (non-Javadoc)
	 * @see spring.day1.spring_07annotation.UserService#regist()
	 */
	public void regist(){
		System.out.println("UserServiceImpl111....regist");
		userDao.save();
	}
}
