package cn.itcast.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

@Controller
public class JsonController {
	
	@Resource
	private ItemsService itemsService;

	/**
	 * 发送json格式数据
	 * @param itemsCustom
	 * @return
	 */
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
	
	/**
	 * 发送key-value格式数据
	 * @param itemsCustom
	 * @return
	 */
	@RequestMapping("/requestKeyValue")
	public @ResponseBody ItemsCustom requestKeyValue(ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
	
	@RequestMapping("/requestRESTful/{id}/{name}")
	public @ResponseBody ItemsCustom requestRESTful(@PathVariable Integer id, @PathVariable String name) throws Exception{
		ItemsCustom itemsCustom = itemsService.queryItemsById(id);
		return itemsCustom;
	}
	
}
