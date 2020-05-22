package cn.zsy.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Title ${PACKAGE_NAME}
 * @date 2020/3/19
 * @autor Zsy
 */
@WebServlet(name = "AjaxServlet")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("AjaxServlet-POST");
        System.out.println("username:"+username+"   password:"+password);

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("AjaxServlet-POST \nusername:"+username+" \npassword:"+password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet-GET");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("AjaxServlet-GET");
    }
}
