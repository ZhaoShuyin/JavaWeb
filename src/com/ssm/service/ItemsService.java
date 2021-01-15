package com.ssm.service;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;

import java.util.List;


public interface ItemsService {

	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) throws Exception;
	
	public ItemsCustom queryItemsById(Integer id) throws Exception;
	
	public void updateItems(ItemsCustom itemsCustom) throws Exception;
}
