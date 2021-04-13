package cn.struts.day2.valid.action;

import org.apache.commons.lang3.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.struts.day2.valid.domain.Student;

/**
 *
 */
public class StudentAction1 extends ActionSupport implements ModelDriven<Student>{
	private Student student = new Student();
	public Student getModel() {
		return student;
	}
	public String query(){
		System.out.println("StudentAction.....query:"+student);
		return null;
	}
	public String regist(){
		System.out.println("StudentAction....regist:"+student);
		return null;
	}
	//验证方法
		//之前做法：定义了一个Map<String,String> errors;存放验证失败后的字段和对应的错误信息
		//如果errors中有元素：说明有验证失败的
		//如果errors没有任何元素：说明验是时成功的。
		//public boolean validate(){return errors.isEmpty();}
	
	//struts2框架也有一个Map<String,String>存放验证失败后的字段和对应的错误信息
	//验证不符合要求的：向map中存放信息即可。
	public void validateRegist() {
		if(StringUtils.isBlank(student.getName())){
			addFieldError("name", "请输入用户姓名");//父类继承的
		}
		if(StringUtils.isBlank(student.getPassword())){
			addFieldError("password", "请输入密码");
		}
	}
}
