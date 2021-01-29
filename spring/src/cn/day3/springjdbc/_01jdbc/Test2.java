package cn.day3.springjdbc._01jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
//Ioc：找Spring要
public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ac =
				new ClassPathXmlApplicationContext("cn/day3/springjdbc/_01jdbc/beans.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
		jdbcTemplate.execute("insert into accounts (name,amount) values ('ggg',1000)");
	}

}
