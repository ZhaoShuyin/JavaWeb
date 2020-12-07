package spring.day1.spring_08junit;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	public void regist() {
		System.out.println("regist...........");
	}

}
