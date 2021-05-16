package com.zsy.ssm.controller;

import com.zsy.ssm.entity.ResBean;
import com.zsy.ssm.entity.User;
import com.zsy.ssm.utils.exception.CustomException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotBlank;

/**
 * @Title com.zsy.ssm.controller
 * @date 2021/5/15
 * @autor Zsy
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    //参数默认获取GET参数
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResBean login(@NotBlank(message = "姓名不能为空") String name,
                         @NotBlank(message = "密码不可为空") String password) {
        System.out.println("==================login()=====================");
        User user = new User();
        user.username = name;
        user.password = password;
        user.birthday = new Date();
        return response("登录成功",user);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public ResBean modify(@Valid @RequestBody User user, BindingResult result) {
        System.out.println("==================modify()=====================");
        if (result.hasErrors()) {
            return response(result);
        }
        return response("修改用户信息", user);
    }

}
