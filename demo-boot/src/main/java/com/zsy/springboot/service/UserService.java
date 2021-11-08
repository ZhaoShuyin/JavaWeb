package com.zsy.springboot.service;

import com.zsy.springboot.bean.ResBean;
import com.zsy.springboot.bean.User;
import com.zsy.springboot.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title com.zsy.springboot.service
 * @date 2021/7/30
 * @autor Zsy
 */
@Service
public class UserService {

    private String TAG = "UserService ";

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响


    public ResBean login(String name, String password) {
        User user = userDao.queryUser("张三");
        if (user == null) {
            return new ResBean(0, "账号错误", null);
        }
        if (!user.password.equals(password)){
            return new ResBean(0, "密码错误", null);
        }
        return new ResBean(1,"登录成功",user);
    }

}
