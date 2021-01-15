package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.ssm.mapper.ItemsCustomMapper;
import com.ssm.mapper.ItemsMapper;
import com.ssm.po.Items;
import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;
import com.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	
	@Resource
	private ItemsCustomMapper itemsCustomMapper;
	
	@Resource
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo)
			throws Exception {
		List<ItemsCustom> itemsList = itemsCustomMapper.queryItems(itemsQueryVo);
		return itemsList;
	}

	@Override
	public ItemsCustom queryItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	
	@Override
	public void updateItems(ItemsCustom itemsCustom) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	


}
