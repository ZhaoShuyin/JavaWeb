package com.zsy.springboot.dao;

import com.zsy.springboot.bean.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * @Title com.zsy.springboot.dao
 * @date 2021/7/30
 * @autor Zsy
 */
@Component
@Mapper
public interface UserDao {

    //查询User
    User queryUser(String name);

}
