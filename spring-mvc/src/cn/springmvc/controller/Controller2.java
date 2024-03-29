package cn.springmvc.controller;

import org.springframework.web.HttpRequestHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.springmvc.po.Items;

/**
 * 第二种方法:实现 HttpRequestHandler 接口
 */
public class Controller2 implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("two controller2...");

        // 构造商品信息数据
        // 实际开发：调用service查找 数据库，查询商品列表，这里使用静态数据模拟
        List<Items> itemsList = new ArrayList<Items>();
        //向list中填充静态数据

        Items items_1 = new Items();
        items_1.setName("Good 2-1");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("Good 2-2");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);

        request.setAttribute("itemsList", itemsList);
        request
                //指向页面地址
                .getRequestDispatcher("items/itemsList")///WEB-INF/jsp/items/itemsList.jsp
                //转发
                .forward(request, response);

    }

}
