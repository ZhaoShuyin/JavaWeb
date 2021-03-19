package cn.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.springmvc.po.Items;

/**
 * 第一个Controller
 * <p>
 * 第一种方法:实现 Controller 接口
 */
public class Controller1 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        System.out.println("one controller1...");

        // 构造商品信息数据
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setName("Good 1-1");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 ");

        Items items_2 = new Items();
        items_2.setName("Good 2-1");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6");

        itemsList.add(items_1);
        itemsList.add(items_2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        return modelAndView;
    }
}
