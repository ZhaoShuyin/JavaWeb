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
        //1.设置响应正文字符集和请求正文字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //2.获取用户到底想要什么操作
        String operate = request.getParameter("operate");//op的意思就是 operate（操作）
        if ("category".equals(operate)) {
            category(request, response);
        }
    }

    /**
     * 条目种类json数据
     */
    private void category(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取所有图书分类
        StringBuffer buffer = new StringBuffer();
        buffer.append("1:文学");
        buffer.append("2:生活");
        buffer.append("3:计算机");
        buffer.append("4:外语");
        buffer.append("5:经营");
        buffer.append("5:经营");
        response.getWriter().write(buffer.toString());
    }

}
