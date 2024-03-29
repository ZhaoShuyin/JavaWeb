package com.mybatis.test;

import com.mybatis.mapper.OrdersMapper;
import com.mybatis.po.Orders;
import com.mybatis.po.OrdersCustom;
import com.mybatis.po.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class OrdersTest {

    // 会话工厂
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        // 获取会话工厂
        String resource = "MyBatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    /**
     * 查询订单细信息并关联查询用户用信息   resultType实现
     *
     * @throws Exception
     */
    @Test
    public void testQueryOrdersAndUserByResultType() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersCustom> list = ordersMapper.queryOrdersAndUserByResultType();
        System.out.println(list);
    }

    /**
     * 查询订单细信息并关联查询用户用信息   resultMap实现
     *
     * @throws Exception
     */
    @Test
    public void testQueryOrdersAndUserByResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = ordersMapper.queryOrdersAndUserByResultMap();
        System.out.println(list);
    }

    /**
     * 查询订单细信息并关联查询明细信息   resultMap实现
     */
    @Test
    public void testQueryOrdersAndDetailByResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = ordersMapper.queryOrdersAndDetailByResultMap();
        System.out.println(list);
    }

    /**
     * 查询用户信息并关联查询商品信息
     *
     * @throws Exception
     */
    @Test
    public void testQueryAll() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> list = ordersMapper.queryAll();
        System.out.println(list);
    }

    /**
     * mybatis的延迟加载
     *
     * @throws Exception
     */
    @Test
    public void testQueryOrdersLazyLoadingByUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = ordersMapper.queryOrdersLazyLoadingByUser();
        Thread.sleep(5000);
        //在使用时使用查询(延迟加载)
        User user = list.get(0).getUser();
        System.out.println(user);
//		for (Orders orders : list) {
//			System.out.println("================  "+orders.getUser());
//		}
    }

    /**
     * mybatis的一级缓存
     *
     * @throws Exception
     */
    @Test
    public void testCacheLevel1() throws Exception {
        // 获取会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 多次操作
        OrdersMapper ordersMapper1 = sqlSession.getMapper(OrdersMapper.class);
        OrdersMapper ordersMapper2 = sqlSession.getMapper(OrdersMapper.class);
        OrdersMapper ordersMapper3 = sqlSession.getMapper(OrdersMapper.class);

        System.out.println("==============第一次查询============ ");
        User user1 = ordersMapper1.queryUserById(1);
        System.out.println("==============第一次查询============ " + user1);

        // commit操作
//        System.out.println("========一级缓存的commit开始=========");
//        user1.setUsername("张明");
//        ordersMapper3.updateUserById(user1);
//        sqlSession.commit();
//        System.out.println("========一级缓存的commit结束=========");

        System.out.println("==============第二次查询============ ");
        User user2 = ordersMapper2.queryUserById(1);
        System.out.println("==============第二次查询============ " + user2);

        sqlSession.close();
    }

    /**
     * mybatis的二级缓存
     *
     * @throws Exception
     */
    @Test
    public void testCacheLevel2() throws Exception {
        // 获取会话
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        // 多次操作
        OrdersMapper ordersMapper1 = sqlSession1.getMapper(OrdersMapper.class);
        OrdersMapper ordersMapper2 = sqlSession2.getMapper(OrdersMapper.class);
        OrdersMapper ordersMapper3 = sqlSession3.getMapper(OrdersMapper.class);

        System.out.println(" ===========  第一次查询 ========= ");
        User user1 = ordersMapper1.queryUserById(1);
        sqlSession1.close();
        System.out.println(" ===========  第一次查询 ========= " + user1);


//         commit操作
//        System.out.println(" ===========  查询后修改 ========= ");
//		user1.setUsername("jerry");
//		ordersMapper3.updateUserById(user1);
//		sqlSession3.commit();
//		sqlSession3.close();
//        System.out.println(" ===========  查询后修改 ========= ");

        // commit操作
//		user1.setUsername("张明");
//		ordersMapper3.updateUserById(user1);
//		sqlSession1.commit();

        System.out.println(" ===========  第二次查询 ========= ");
        User user2 = ordersMapper2.queryUserById(1);
        sqlSession2.close();
        System.out.println(" ===========  第二次查询 ========= " + user2);

    }

}
