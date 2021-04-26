package com.zsy.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zsy.ssh.domain.User;
import com.zsy.ssh.service.UserService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Title com.zsy.ssh.action
 * @date 2021/4/26
 * @autor Zsy
 */

@Component("userQuery")
@Scope("prototype")  // 每个请求对应一个Action对象
public class UserAction extends ActionSupport {

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    private Object object;

    @Resource(name = "userService")
    private UserService userService;

    @Override
    public String execute() throws Exception {
        User query = userService.query(1);
        object = query;
        return SUCCESS;
    }
}
