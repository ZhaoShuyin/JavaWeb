package cn.day3.springjdbc._02daoSupport;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

//JdbcDaoSupport
public class DaoImpl2 extends JdbcDaoSupport {

    public void save() {
        getJdbcTemplate()
                .execute(
                        "insert into accounts (name,amount) values ('jjj',1000)"
                );
    }

}
