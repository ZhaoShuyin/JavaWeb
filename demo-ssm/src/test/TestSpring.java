package test;

import com.alibaba.fastjson.JSON;
import com.zsy.ssm.dao.UserMapper;
import com.zsy.ssm.entity.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title test
 * @date 2021/5/15
 * @autor Zsy
 */

public  class TestSpring {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/spring-dao.xml");

        Object sessionFactory = ac.getBean("sqlSessionFactory");

        System.out.println("========================");

        DefaultSqlSessionFactory factory = (DefaultSqlSessionFactory) sessionFactory;
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryById(1);
        System.out.println(JSON.toJSONString(user));
//        SqlSessionFactoryBean sqlSession = (SqlSessionFactoryBean) ac.getBean("sqlSessionFactory");

        System.out.println("========================");
        System.out.println(sessionFactory.getClass().getName());

    }

}
