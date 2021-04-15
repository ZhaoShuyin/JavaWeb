package cn.struts.day5.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.struts.day5.domain.User;
import cn.struts.day5.exception.IdIsNullException;
import cn.struts.day5.exception.UsernameExistException;
import cn.struts.day5.service.UserService;
import cn.struts.day5.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private UserService userService = new UserServiceImpl();

    //用户注销
    public String logout() {
        ActionContext.getContext().getSession().remove("user");
        return SUCCESS;
    }

    //用户登陆
    public String login() {
        User u = userService.login(user.getUsername(), user.getPassword());
        if (u == null) {
            addActionMessage("错误的用户名或密码");
            return LOGIN;
        }
        ActionContext.getContext().getSession().put("user", u);
        return SUCCESS;
    }


    //条件查询
    public String findUser() {
        users = userService.findUser(user.getNickname(), user.getGender(), user.getDegrees(), user.getFilename());
        return SUCCESS;
    }

    //保存修改后的信息：模型对象中。id nickname gender birthday degrees phonenum hobby description
    //注意：username password path filename不要搞丢了
    public String editUser() {
        ServletContext sc = ServletActionContext.getServletContext();
        //为了保证数据：username password不会被丢失
        User dbUser = userService.findUserById(user.getId());
        user.setUsername(dbUser.getUsername());
        user.setPassword(dbUser.getPassword());

        if (resume == null) {//用户没有重新上传：用原来
            user.setPath(dbUser.getPath());
            user.setFilename(dbUser.getFilename());
        } else {
            //用户重新上传了文件:上传还要做一遍（设置路径和文件名）；老文件要删掉；

            //指定存放上传文件的目录
            String rootDirectory = sc.getRealPath("/files");//得到存放文件的真实路径（根目录）
            //产生一个子目录:按照日期产生子目录
            String childDirectory = makeChildDirectory(rootDirectory);

            user.setPath(File.separator + "files" + File.separator + childDirectory);// /files/2015-10-09

            //处理文件名：个人简历.doc
            String filename = UUID.randomUUID() + "_" + resumeFileName;//  sdfs-sdfds-dsf-ds_个人简历.doc
            user.setFilename(filename);
            //文件上传
            try {
                FileUtils.moveFile(resume, new File(rootDirectory + File.separator + childDirectory, filename));
            } catch (IOException e) {
                e.printStackTrace();
                return ERROR;
            }
//			老文件要删掉；

            String realPath = sc.getRealPath(dbUser.getPath());
            File oldFile = new File(realPath + File.separator + dbUser.getFilename());
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }
        try {
            userService.updateUser(user);
        } catch (IdIsNullException e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }

    //修改页面
    public String editUserUI() {
        User u = userService.findUserById(user.getId());
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.push(u);//压入栈顶
        return SUCCESS;
    }


    //文件下载
    private InputStream inputStream;//下载流
    private String downloadFileName;//下载时用的文件名  简历.doc

    public String downloadResume() {
        //根据id查询用户的信息
        User u = userService.findUserById(user.getId());
        String path = u.getPath();//文件存放路径   /files/2015-10-24
        String filename = u.getFilename();//真实文件名
        String realPath = ServletActionContext.getServletContext().getRealPath(path);
        try {
            inputStream = new FileInputStream(realPath + File.separator + filename);
            //截取文件名
            downloadFileName = filename.substring(filename.indexOf("_") + 1);//简历
            //文件名URL编码（除了火狐）
            HttpServletRequest request = ServletActionContext.getRequest();
            String userAgent = request.getHeader("User-Agent");//客户端用的是什么浏览器
            if (userAgent.toLowerCase().contains("firefox")) {
                downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO-8859-1");//解决火狐乱码问题
            } else {
                //其他浏览器,标准--文件名要进行URL编码
                downloadFileName = URLEncoder.encode(downloadFileName, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }

    //查看用户信息:id在模型对象中
    public String showUser() {
        User u = userService.findUserById(user.getId());
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.push(u);//压入栈顶
        return SUCCESS;
    }


    //删除用户：id在模型对象中
    public String deleteUser() {
        userService.deleteUser(user.getId());
        return SUCCESS;
    }


    //添加用户:String[]--->String:struts2是可以的，元素用逗号+空格进行分隔
    //确认密码：repassword
    private String repassword;
    //文件上传:字段resume
    private File resume;
    private String resumeFileName;

    /**
     *
     * @return
     */
    public String addUser() {
        if (resume != null) {//用户选择上传文件时才处理上传
            //指定存放上传文件的目录
            ServletContext sc = ServletActionContext.getServletContext();
            String rootDirectory = sc.getRealPath("/files");//得到存放文件的真实路径（根目录）
            //产生一个子目录:按照日期产生子目录
            String childDirectory = makeChildDirectory(rootDirectory);

            user.setPath(File.separator + "files" + File.separator + childDirectory);// /files/2015-10-09

            //处理文件名：个人简历.doc
            String filename = UUID.randomUUID() + "_" + resumeFileName;//  sdfs-sdfds-dsf-ds_个人简历.doc
            user.setFilename(filename);
            //文件上传
            try {
                FileUtils.moveFile(resume, new File(rootDirectory + File.separator + childDirectory, filename));
            } catch (IOException e) {
                e.printStackTrace();
                return ERROR;
            }
        }
        try {
            userService.saveUser(user);
        } catch (UsernameExistException e) {
            addFieldError("username", "用户名已经存在了");
            return INPUT;
        }

        return SUCCESS;
    }

    //按照日期产生子目录
    private String makeChildDirectory(String rootDirectory) {
        String childDirectory = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(rootDirectory, childDirectory);
        if (!file.exists())
            file.mkdirs();
        return childDirectory;
    }

    //查询所有用户
    private List<User> users;

    public String listUsers() {
        users = userService.findAllUsers();
        return SUCCESS;
    }

    public User getModel() {
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public File getResume() {
        return resume;
    }

    public void setResume(File resume) {
        this.resume = resume;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getDownloadFileName() {
        return downloadFileName;
    }

    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

}
