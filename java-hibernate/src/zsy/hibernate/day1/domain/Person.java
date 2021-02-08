package zsy.hibernate.day1.domain;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	private Integer id;
	private String name;
	private String idcard;//身份证号码
	private Date registDate;//注册日期
	
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
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
}
