package cn.struts.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;

/**
 * @Title cn.struts.json
 * @date 2021/4/18
 * @autor Zsy
 */
public class JsonAction2 extends ActionSupport {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User user = new User();

    /**
     * 直接使用插件返回变量User 需Getter方法
     */
    public String objectJson() {
        user.setNickname("这是昵称呀");
        return SUCCESS;
    }

}
