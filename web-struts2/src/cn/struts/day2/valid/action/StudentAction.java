package cn.struts.day2.valid.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.struts.day2.valid.domain.Student;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    private Student student = new Student();

    public Student getModel() {
        return student;
    }

    @SkipValidation
    public String query() {
        System.out.println("StudentAction.....query:" + student);
        return SUCCESS;
    }

    public String regist() {
        System.out.println("StudentAction....regist:" + student);
        return SUCCESS;
    }
}
