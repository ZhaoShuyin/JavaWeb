package cn.struts.day3.upload.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传动作类必须继承ActionSupport（要用到文本提示）
 */
public class Upload1Action extends ActionSupport {

    private String name;                 //普通字段struts2也可以直接使用
    private File photo;                  //固定写法。类型File，变量名和表单保持一致
    private String photoFileName;        //上传的文件的名字。固定写法。类型String，上传字段名FileName
    private String photoContentType;     //上传的文件的MIME类型。固定写法。类型String，上传字段名ContentType

    //完成上传即可
    public String execute() throws Exception {
        ServletContext sc = ServletActionContext.getServletContext();
        String storeDirectory = sc.getRealPath("/files");
        System.out.println("下载路径 ==> " + storeDirectory);
        FileUtils.moveFile(photo, new File(storeDirectory, photoFileName));
        return NONE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

}
