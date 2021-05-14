package com.itcast.mybatis.dao;

import com.itcast.mybatis.po.User;

public interface UserDao {
    public User queryUserById(int id) throws Exception;
}
