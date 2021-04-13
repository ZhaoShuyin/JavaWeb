package cn.day1.spring_07annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ServiceA")
public class ServiceA implements IService {

	@Autowired
	@Qualifier("user")
	private UserImpl userDao;
	/* (non-Javadoc)
	 * @see cn.struts.day2.regist.spring_07annotation.UserService#regist()
	 */

	public ServiceA() {
		System.out.println("ServiceA 构造方法");
	}

	public void regist(){
		System.out.println("ServiceA regist 方法 (调用成员变量User.save)");
		userDao.save();
	}
}
