package cn.struts.day3.upload.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
//文件下载
public class Download2Action extends ActionSupport {

	private InputStream inputStream;    //名字最好不要叫in（struts2有bug）
	private long fileLength;            //文件大小
	private String filename;            //文件名

	public String execute() throws Exception{
		//找到要下载的文件的真实路径
		ServletContext sc = ServletActionContext.getServletContext();
		String realPath = sc.getRealPath("/WEB-INF/files/1.jpg");
		
		filename = FilenameUtils.getName(realPath);// substring
		//中文文件名下载时：标准--文件名要进行URL编码
		HttpServletRequest request = ServletActionContext.getRequest();
		String userAgent = request.getHeader("User-Agent");          //客户端用的是什么浏览器
		if(userAgent.toLowerCase().contains("firefox")){
			filename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");//解决火狐乱码问题
		}else{
			//其他浏览器,标准--文件名要进行URL编码
			filename = URLEncoder.encode(filename, "UTF-8");
		}
		inputStream = new FileInputStream(realPath);
		fileLength = inputStream.available();
		return SUCCESS;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public long getFileLength() {
		return fileLength;
	}

	public void setFileLength(long fileLength) {
		this.fileLength = fileLength;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
