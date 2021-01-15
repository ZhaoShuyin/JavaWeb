package com.spring.day1.spring_07annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {
	
	@Value("陈涔")//注入基本类型。意义不大
	private String name;
	
//	@Autowired //默认按照类型进行注入
//	@Autowired(required=true)//required:
//									//true:必须注入，如果注入失败，抛异常
//									//false:非必须的，如果注入失败，就失败
//	@Qualifier("userService")
	
	
	@Resource(name="userService")
	private UserService userSerice;//setter方法不是必须的
	
	public String execute(){
		System.out.println("UserAction....execute:"+name);
		userSerice.regist();
		return null;
	}
}
