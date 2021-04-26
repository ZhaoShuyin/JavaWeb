package com.zsy.ssh.service;

import com.zsy.ssh.dao.UserDao;
import com.zsy.ssh.domain.User;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Title com.zsy.ssh.service
 * @date 2021/4/26
 * @autor Zsy
 */

@Service("userService")
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public User query(Integer integer){
        return userDao.queryBuId(integer);
    }
}
