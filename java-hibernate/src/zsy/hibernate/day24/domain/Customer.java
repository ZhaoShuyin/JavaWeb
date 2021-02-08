package cn.itcast.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	private Integer id;
	private String name;
	private Address homeAddress;
	private Address comAddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getComAddress() {
		return comAddress;
	}
	public void setComAddress(Address comAddress) {
		this.comAddress = comAddress;
	}
	
}
