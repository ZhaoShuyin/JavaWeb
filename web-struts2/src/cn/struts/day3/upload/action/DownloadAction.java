package cn.struts.day3.upload.action;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件下载
 */
public class DownloadAction extends ActionSupport {

	private InputStream inputStream; //名字最好不要叫in（struts2有bug）
	private long fileLength;         //文件大小

	//完成下载：给输入流赋值即可
	public String execute() throws Exception{
		//找到要下载的文件的真实路径
		ServletContext sc = ServletActionContext.getServletContext();
		String realPath = sc.getRealPath("/WEB-INF/files/1.jpg");
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
	
	
}
