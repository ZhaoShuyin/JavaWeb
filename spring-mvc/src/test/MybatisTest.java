package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @Title test
 * @date 2021/5/14
 * @autor Zsy
 */

public class MybatisTest {

    public static void main(String[] args) {
     /*   String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 1、sqlSessionFactory获取
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // 2、获取回话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、api调用
        *//**
         * arg0:namespace+"."+id
         * arg1:参数
         *//*
        List<Object> objects = sqlSession.selectList("test.queryUserById", 1);
        System.out.println(objects);*/
    }

}
