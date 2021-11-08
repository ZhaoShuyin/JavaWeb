package com.zsy.springboot.bean;

/**
 * @Title com.zsy.springboot.bean
 * @date 2021/7/29
 * @autor Zsy
 */

public class User {

    public String name;

    public String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
