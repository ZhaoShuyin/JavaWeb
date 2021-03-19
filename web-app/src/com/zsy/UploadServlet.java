package com.zsy;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上传文件接口
 */
@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {

    /**
     * 通过线程锁保证文件名称唯一
     */
    public static synchronized String getFileName() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(System.currentTimeMillis());
    }

    public static final String Path = "D:/Test/upload";             //头像文件路径名称
    public static final String portrait = "portrait";             //头像文件路径名称
    public static final String picture = "picture";               //普通文件路径名称
    public static final String certificate = "certificate";       //认证文件路径名称

    /**
     * 静态代码块创建路径文件
     */
    static {
        File file1 = new File(Path + portrait);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File file2 = new File(Path + picture);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(Path + certificate);
        if (!file3.exists()) {
            file3.mkdirs();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletUtil.onlyPost(response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultiForm = ServletFileUpload.isMultipartContent(request);
        if (!isMultiForm) {
            response.getWriter().write("不支持文件上传");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        String uionName = getFileName();
        File file = null;     //创建新文件
        String fileType = "";
        try {
            List items = upload.parseRequest(request);
            for (Object object : items) {
                FileItem item = (FileItem) object;
                String fieldName = item.getFieldName();
                if (item.isFormField()) { //普通字段
                    if (fieldName.equals("filetype")) {
                        fileType = item.getString();
                    }
                    System.out.println("fieldName: " + fieldName + " getString " + item.getString());
                } else {
                    String fileName = item.getName();
                    file = new File(
                            Path + "/"
                                    + uionName + "."
                                    + fileName.substring(fileName.lastIndexOf(".") + 1));
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        InputStream in = item.getInputStream();
                        byte[] chs = new byte[1024];
                        int len = 0;
                        while ((len = in.read(chs)) != -1) {
                            out.write(chs, 0, len);
                        }
                        out.close();
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        if (file != null) {
            file.setReadable(true, false);
            file.setExecutable(true, false);
            file.setWritable(true, false);
        }
        System.out.println("================================" + file.getAbsolutePath());
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("上传完毕");
    }


}
