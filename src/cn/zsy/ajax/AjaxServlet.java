package cn.zsy.ajax;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

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
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String mapKey = entry.getKey();
            String[] mapValue = entry.getValue();
            builder.append(mapKey + "\n");
            builder.append("  " + Arrays.toString(mapValue) + "\n");
        }
        String parameters = builder.toString();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("getParameter \nparameters: \n" + parameters);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet-GET");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("AjaxServlet-GET");
    }

}
