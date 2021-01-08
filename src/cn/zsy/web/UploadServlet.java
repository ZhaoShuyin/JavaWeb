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
        String type = request.getParameter("type");

        /**
         *
         */
        String path = "D:/Test/upload";
        long millis = System.currentTimeMillis();
        File file;
        if (type != null) {
            file = new File(path, "ecg-" + millis + ".txt");
        } else {
            file = new File(path, "ecg-" + millis + ".xml");
        }
        System.out.println("type: "+type);

        if (!file.exists()) {
            file.createNewFile();
        }
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
        String json = "{\"Status\":\"1\"}";
        if (type != null) {
            json = "{\"code\":1,\"data\":\""+result+"\"}";
        } else {
            json = "{\"Status\":\"1\"}";
        }
        printWriter.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print("GET不支持上传文件");
    }

    public static String result =
            "HR= 54\n" +
                    "P_width= 100\n" +
                    "QRS_width= 139\n" +
                    "axis_qrs= 22\n" +
                    "PR= 150\n" +
                    "RV5= 0.860667\n" +
                    "SV1= -0.296222\n" +
                    "QT= 554\n" +
                    "QTc= 526\n" +
                    "Conclusion= 窦性心律\n" +
                    "\n" +
                    "异常心电图\n" +
                    "\n" +
                    "窦性心动过缓\n" +
                    "\n" +
                    "不完全性右束支传导阻滞\n" +
                    "异常Q波：II  III  avF  \n" +
                    "T波倒置：II  III  avF  I  avL  V6  V1  V2  V3  V4  V5  ";
}
