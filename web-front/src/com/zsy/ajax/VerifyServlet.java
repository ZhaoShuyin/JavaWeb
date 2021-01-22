package com.zsy.ajax;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Title ${PACKAGE_NAME}
 * @date 2020/3/19
 * @autor Zsy
 * <p>
 * <!---->
 * <servlet>
 * <servlet-name>Ajax01</servlet-name>
 * <servlet-class>cn.zsy.ajax.VerifyServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * <servlet-name>Ajax01</servlet-name>
 * <url-pattern>/ajax01</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(name = "AjaxServlet")
public class VerifyServlet extends HttpServlet {

    public static HashMap<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        hashMap.put("3", "3");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("type");
        response.setCharacterEncoding("UTF-8");
        if (type == null) {
            response.getWriter().write("未指定type");
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(type + " - " + username + " - " + password);
        if (type.equals("check")) {
            if (hashMap.containsKey(username)) {
                response.getWriter().write("用户名<" + username + ">已存在 type:" + type);
            } else {
                response.getWriter().write("用户名<" + username + ">未使用 type:" + type);
            }
        }
        if (type.equals("regist")) {
            String put = hashMap.put(username, password);
            response.getWriter().write("注册完毕: type:" + type + "\nput:" + put);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet-GET");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("AjaxServlet-GET");
    }
}
