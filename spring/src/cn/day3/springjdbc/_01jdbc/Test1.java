package cn.day3.springjdbc._01jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 自己手工写的代码创建数据源
 */
public class Test1 {

	public static void main(String[] args) {
		//Spring框架提供的数据源
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		jdbcTemplate.execute("insert into accounts (name,amount) values ('ccc',1000)");
	}

}
