package com.zsy.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title ${PACKAGE_NAME}
 * @date 2019/12/27
 * @autor Zsy
 */
@WebServlet(name = "BootServlet")
public class BootServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Content-Type →text/html;charset=ISO-8859-1
        // response.setContentType("text/html");

        Enumeration<String> names = request.getParameterNames();
        StringBuilder builder = new StringBuilder();
        while (names.hasMoreElements()) {
            String param = names.nextElement();
            builder.append("param = " + param + " : " + request.getParameter(param) + "\n");
        }
        //设置编码格式
        response.setCharacterEncoding("utf-8");

        builder.append(postFormParam(request));//

        PrintWriter out = response.getWriter();
        out.println(builder.toString());
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder builder = new StringBuilder();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            builder.append("param = " + param + " : " + request.getParameter(param) + "\n");
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("name:" + name + " , age:" + age + "\ngetParameterNames:\n" + builder.toString());
    }

    /**
     *
     */
    private String postFormValue(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("==========body=============\n");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        builder.append("\n==========body=============");
        return builder.toString();
    }


    /**
     * @return
     */
    private String postFormParam(HttpServletRequest request) throws UnsupportedEncodingException {
        // 针对post请求，设置允许接收中文
        request.setCharacterEncoding("utf-8");
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List items = upload.parseRequest(request);
            StringBuilder builder = new StringBuilder();
            for (Object object : items) {
                FileItem item = (FileItem) object;
                String name = item.getFieldName();
                builder.append("----------\n");
                builder.append(name + "\n");
                if (item.isFormField()) {
                    builder.append(item.getString("utf-8") + "\n");
                }
                if (name.equals("filename")) {
                    try {
                        InputStream inputStream = item.getInputStream();
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        byte[] chs = new byte[1024];
                        int len = 0;
                        while ((len = bufferedInputStream.read(chs)) != -1) {
                            String str = new String(chs, 0, len);
                            String s = new String(str.getBytes(), "utf-8");
                            builder.append(s);
                        }
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                builder.append("\n----------");
            }
            return builder.toString();
        } catch (FileUploadException e1) {
            e1.printStackTrace();
            return "empty";
        }
    }

}
