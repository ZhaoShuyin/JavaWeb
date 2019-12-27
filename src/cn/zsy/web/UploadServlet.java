package cn.zsy.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

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
@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         *
         */
        String path = request.getRealPath("/upload");
        long millis = System.currentTimeMillis();
        File file = new File(path, "ecg-" + millis + ".xml");
        OutputStream out = new FileOutputStream(file);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        InputStream in = request.getInputStream();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = in.read(bytes)) != -1) {
            bout.write(bytes, 0, len);
        }
        in.close();
        bout.close();
        out.close();
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        String message = "上传完毕 保存文件名文件  < ecg-" + millis + " > 文件大小: " + file.length();
        String json = "{ \"Status\":1,\"Mes\":\"" + message + "\"}";
        printWriter.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print("GET不支持上传文件");
    }
}
