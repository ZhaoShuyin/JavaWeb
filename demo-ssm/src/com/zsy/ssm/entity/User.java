package com.zsy.ssm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;



import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


//import javax.validation.constraints.Size;

//import jakarta.validation.constraints.Size;

//import org.hibernate.validator.constraints.NotBlank;
//import javax.validation.constraints.NotBlank;

/**
 * @Title com.zsy.ssm.entity
 * @date 2021/5/15
 * @autor Zsy
 */
public class User implements Serializable {

    public Integer id;
    //使用注解校验
    @NotBlank(message = "name不可为空")
    @Size(min = 1,max = 10,message = "名称长度1~10")
    public String username;
    @Size(min = 3,max = 10)
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "密码格式为大小写字母及数字")
    public String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
