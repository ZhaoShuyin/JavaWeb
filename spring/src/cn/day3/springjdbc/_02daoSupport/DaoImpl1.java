package cn.day3.springjdbc._02daoSupport;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * <!-- Impl1 成员变量jdbcTemplate 使用jdbcT -->
 * <bean id="Impl1" class="cn.day3.springjdbc._02daoSupport.DaoImpl1">
 * <property name="jdbcTemplate" ref="jdbcT"></property>
 * </bean>
 */
public class DaoImpl1 {
    //
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("setJdbcTemplate");
    }

    public void insert() {
        System.out.println("insert >> " + jdbcTemplate);
        jdbcTemplate.execute("insert into accounts (name,amount) values ('hhh',1000)");
    }
}
