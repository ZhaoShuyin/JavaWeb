package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import cn.springmvc.po.Items;

/**
 * 第三种方法 使用@Controller注解
 */
@Controller
@RequestMapping("/item") // namespace
public class Controller3 {

    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView queryItems() {

        System.out.println("three controller3...");

        // 构造商品信息数据
        // 实际开发：调用service查找 数据库，查询商品列表，这里使用静态数据模拟
        List<Items> itemsList = new ArrayList<Items>();
        //向list中填充静态数据

        Items items_1 = new Items();
        items_1.setName("Goods 3-1");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430");

        Items items_2 = new Items();
        items_2.setName("Goods 3-2");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6");

        itemsList.add(items_1);
        itemsList.add(items_2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }
}
