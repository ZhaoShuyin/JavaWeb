package cn.struts.day2.regist.service;


import cn.struts.day2.regist.domain.Student;

public interface StudentService {
	/**
	 * 完成学员信息注册
	 * @param student
	 */
	void regist(Student student);
}
