package com.spring.day1.spring_02init;

public class UserDaoImpl implements UserDao {
	public void save() {
		int hashCode = System.identityHashCode(this);
		System.out.println("@<"+hashCode+">  UserDaoImpl save 方法");
	}
}
