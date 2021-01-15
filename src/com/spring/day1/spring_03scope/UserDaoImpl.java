package com.spring.day1.spring_03scope;

public class UserDaoImpl implements UserDao {
	public void save() {
		int hashCode = System.identityHashCode(this);
		System.out.println("@<"+Integer.toHexString(hashCode)+"> UserDaoImpl save....");
	}
}
