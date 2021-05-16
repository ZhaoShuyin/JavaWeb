package com.zsy.ssm.dao;

import com.zsy.ssm.entity.User;

import java.util.List;

/**
 * @Title com.zsy.ssm.dao
 * @date 2021/5/15
 * @autor Zsy
 */
public interface UserMapper {

    User queryById(int id);

    List<User> queryByName(String username);

    int insertUser(User user);

    int updateUser(User user);
}
