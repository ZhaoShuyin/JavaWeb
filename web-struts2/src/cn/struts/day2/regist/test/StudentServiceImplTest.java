package cn.struts.day2.regist.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.struts.day2.regist.domain.Student;
import cn.struts.day2.regist.service.StudentService;
import cn.struts.day2.regist.service.impl.StudentServiceImpl;

public class StudentServiceImplTest {
    private StudentService s = new StudentServiceImpl();

    @Test
    public void testRegist() {
        Student stu = new Student();
        stu.setName("陈岑");
        stu.setAge(22);
        stu.setGender("女");
        s.regist(stu);
    }

}
