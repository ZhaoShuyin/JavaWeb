package cn.struts.day2.regist.domain;

import java.io.Serializable;
import java.util.Date;

/*
create database day27;
use day27;
create table students(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	age int,
	gender varchar(10),
	birthday date
);
 */
public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age
                + ", gender=" + gender + ", birthday=" + birthday + "]";
    }

}
