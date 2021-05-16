package cn.itcast.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import cn.itcast.ssm.mapper.ItemsCustomMapper;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.utils.exception.CustomException;

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
		if (items!=null) {
			BeanUtils.copyProperties(items, itemsCustom);
			return itemsCustom;
		}else{
			throw new CustomException("查询的商品信息不存在");
		}
	}

	
	@Override
	public void updateItems(ItemsCustom itemsCustom) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	


}
