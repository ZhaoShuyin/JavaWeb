package com.spring.day1.spring_07annotation;

import org.springframework.stereotype.Repository;

//@Component
//持久层
@Repository("userDao")
public class UserDaoImpl {
	public void save(){
		System.out.println("UserDaoImpl....save");
	}
}
