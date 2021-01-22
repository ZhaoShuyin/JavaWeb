package cn.day1.spring_07annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ServiceB")
public class ServiceB implements IService {
	@Autowired
	@Qualifier("user")
	private UserImpl userDao;

	public ServiceB() {
		System.out.println("ServiceB 构造方法");
	}

	/* (non-Javadoc)
	 * @see cn.itcast.spring_07annotation.UserService#regist()
	 */
	public void regist(){
		System.out.println("ServiceB regist 方法 (调用成员变量User.save)");
		userDao.save();
	}
}
