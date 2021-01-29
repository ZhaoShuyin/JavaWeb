package cn.day3.springjdbc._02daoSupport;

import org.springframework.jdbc.core.JdbcTemplate;

public class DaoImpl1 {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("setJdbcTemplate");
    }

    public void insert() {
        System.out.println("insert >> "+jdbcTemplate);
        jdbcTemplate.execute("insert into accounts (name,amount) values ('hhh',1000)");
    }
}
