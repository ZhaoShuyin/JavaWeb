package com.zsy.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zsy.ssh.domain.User;
import com.zsy.ssh.service.UserService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Title com.zsy.ssh.action
 * @date 2021/4/26
 * @autor Zsy
 */

@Component("userQuery")
@Scope("prototype")            // 每个请求对应一个Action对象
@ParentPackage("json-default")
@Namespace("/user")  //命名空间
@Results({@Result(type = "json", params = {"root", "object"}, name = "query")})
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

    @Action(value = "query", results = {@Result(name = "query", type = "json", params = {"root", "object"})})
    public String query() {
        System.out.println(" 查询     Action : " + this);
        User query = userService.query(1);
        object = query;
        return "query";
    }
}
