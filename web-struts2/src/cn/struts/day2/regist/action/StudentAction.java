package cn.struts.day2.regist.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.struts.day2.regist.domain.Student;
import cn.struts.day2.regist.service.StudentService;
import cn.struts.day2.regist.service.impl.StudentServiceImpl;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    private Student student = new Student();

    public Student getModel() {
        return student;
    }

    private StudentService s = new StudentServiceImpl();

    public String regist() {
        try {
            s.regist(student);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
