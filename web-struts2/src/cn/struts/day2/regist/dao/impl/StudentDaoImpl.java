package cn.struts.day2.regist.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.struts.day2.regist.dao.StudentDao;
import cn.struts.day2.regist.domain.Student;
import cn.struts.day2.regist.util.C3P0Util;

public class StudentDaoImpl implements StudentDao {
    private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

    public void save(Student student) {
        try {
            qr.update("insert into students(name,age,gender,birthday) values (?,?,?,?)",
                    student.getName(), student.getAge(), student.getGender(), student.getBirthday());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
