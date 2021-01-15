package com.ssm.controller;

import com.ssm.po.ItemsCustom;
import com.ssm.service.ItemsService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Resource
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
		// 查询商品列表信息
		List<ItemsCustom> itemsList = itemsService.queryItems(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	@RequestMapping("/editItems")
	public String editItems(Model model,@RequestParam(value="id",defaultValue="2") Integer items_id) throws Exception{
		ItemsCustom itemsCustom = itemsService.queryItemsById(items_id); // 参数绑定 没讲   静态数据
		model.addAttribute("items", itemsCustom);
		return "items/editItems";
	}
	
	@RequestMapping("/updateItems")
	public String updateItems(ItemsCustom itemsCustom) throws Exception{
		
//		String name = new String(itemsCustom.getName().getBytes("ISO-8859-1"), "UTF-8");
		itemsService.updateItems(itemsCustom);
		return "redirect:queryItems.action";
//		return "forward:queryItems.action";
	}

}
