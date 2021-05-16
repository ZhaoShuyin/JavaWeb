package test;

import com.alibaba.fastjson.JSON;
import com.zsy.ssm.dao.UserMapper;
import com.zsy.ssm.entity.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * @Title test
 * @date 2021/5/15
 * @autor Zsy
 */

public class TestMyBatis {

    private static SqlSession getSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
        // 1、sqlSessionFactory获取
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        // 2、获取回话
        return factory.openSession();
    }

    public static void main(String[] args) throws IOException {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.id = 14;
        user.username = "修改的";
        int i = mapper.updateUser(user);
        System.out.println(" = update : "+i);
        session.commit();
    }

    private static void test3() throws IOException {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.queryByName("李四");
        System.out.println(users.size());
        session.commit();
    }

    private static void test2() throws IOException {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.username = "李四";
        user.password = "123";
        user.birthday = new Date();
        int id = mapper.insertUser(user);
        System.out.println("========== insert id : " + id);
        System.out.println("user ; " + user.id);
        session.commit();
    }

    private static void test1() throws IOException {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryById(1);
        System.out.println("==============================");
        System.out.println(JSON.toJSONString(user));
        session.commit();
    }


}
