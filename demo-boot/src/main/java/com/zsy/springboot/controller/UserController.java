package com.zsy.springboot.controller;

import com.zsy.springboot.bean.ResBean;
import com.zsy.springboot.bean.User;
import com.zsy.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title com.zsy.springboot.controller
 * @date 2021/7/29
 * @autor Zsy
 */
@Controller()
@RequestMapping(value = "/user")
public class UserController {

    private String TAG = "UserController ";

    @Autowired
    private UserService service;

    /**
     * @ResponseBody 可以直接返回字符串
     */
    @ResponseBody
    @GetMapping(value = "/login")
    public ResBean login(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password) {
        System.out.println("login() name:" + name + " , password:" + password);
        return service.login(name, password);
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public ResBean login(@RequestBody User user) {
        System.out.println("login() user:" + user.toString());
        return service.login(user.name, user.password);
    }


}
