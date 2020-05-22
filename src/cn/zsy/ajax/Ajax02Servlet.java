package cn.zsy.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title ${PACKAGE_NAME}
 * @date 2020/4/9
 * @autor Zsy
 */
@WebServlet(name = "Ajax02Servlet")
public class Ajax02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StringBuffer buffer = new StringBuffer();
        buffer.append("[AAA,BBB,CCC]");
        response.getWriter().write(buffer.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet-GET");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("AjaxServlet-GET");
    }
}
