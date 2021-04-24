package cn.day3.springjdbc._03tx;

import java.io.Serializable;
/*
use day36;
create table accounts(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	amount float(8,2)
);
insert into accounts (name,amount) values ('aaa',1000);
insert into accounts (name,amount) values ('bbb',1000);
 */
public class Account implements Serializable {
	private Integer id;
	private String name;//账户，唯一
	private Float amount;//余额
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
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", amount=" + amount
				+ "]";
	}
	
}
