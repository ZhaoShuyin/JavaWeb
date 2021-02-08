package cn.itcast.domain;

import java.io.Serializable;
//值对象：一段数据
//实体对象：有OID，一条记录
public class Address implements Serializable {
	private String province;
	private String city;
	private String street;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
}
