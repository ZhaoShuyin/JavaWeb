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

/**
 * @Title cn.struts.json
 * @date 2021/4/18
 * @autor Zsy
 */

public class JsonAction extends ActionSupport {

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
        user.setPassword("密码");
        return SUCCESS;
    }

    /**
     * 使用 PrintWriter
     */
    public void writeJson() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        //以下代码从JSON.java中拷过来的
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //将要被返回到客户端的对象
        User user = new User();
        user.setId(123);
        user.setUsername("JSONActionGeneral");
        user.setPassword("JSON");
        user.setHobby("Hello , i am a action to print a json!");
        out.println(JSONObject.toJSONString(user));
        out.flush();
        out.close();
    }

    public User getReqUser() {
        return reqUser;
    }

    private User reqUser;

    /**
     * 获取接口传递的JSON数据
     */
    public String getJsonReqData() {
        // 获取Request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        StringBuffer sb = new StringBuffer();
        try {
            // json格式字符串
            String jsonStr = "";
            // 获取application/json格式数据，返回字符流
            BufferedReader reader = request.getReader();
            // 对字符流进行解析
            while ((jsonStr = reader.readLine()) != null) {
                sb.append(jsonStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = sb.toString();
        System.out.println("请求参数: " + text);
        reqUser = JSON.parseObject(text, User.class);
        System.out.println("parseObject : "+JSON.toJSONString(reqUser));
        return SUCCESS;
    }

}
