package cn.struts.day2.regist.service.impl;


import cn.struts.day2.regist.dao.StudentDao;
import cn.struts.day2.regist.dao.impl.StudentDaoImpl;
import cn.struts.day2.regist.domain.Student;
import cn.struts.day2.regist.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    public void regist(Student student) {
        if (student == null)
            throw new IllegalArgumentException("What are you doing....");
        studentDao.save(student);
    }

}
