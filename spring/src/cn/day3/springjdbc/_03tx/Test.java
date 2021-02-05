package cn.day3.springjdbc._03tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Test {

    private static DriverManagerDataSource dataSource;

    public static void main(String[] args) {

        frist();

        ApplicationContext ac =
                new ClassPathXmlApplicationContext(
                        "cn/day3/springjdbc/_03tx/beans.xml"
                );
        IService s = (IService) ac.getBean("accountService");
//		s.transferTransaction("aaa", "bbb", 1f);
//		s.transfer("aaa", "bbb", 1f);
        s.m1();

        show("结果");
    }

    public static void frist() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());

        int update = jdbcTemplate.update("update accounts set amount =100");
        System.out.println("  init >>>>>>>>>> " + update);

        show("开始");
    }

    private static DriverManagerDataSource getDataSource() {
        if (dataSource != null) {
            return dataSource;
        }
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    public static void show(String tag) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());

        List<Account> query = jdbcTemplate.query("select * from accounts", new AccountRowMapper());
        for (int i = 0; query != null && i < query.size(); i++) {
            System.out.println(tag + " >> " + query.get(i));
        }
    }

}
