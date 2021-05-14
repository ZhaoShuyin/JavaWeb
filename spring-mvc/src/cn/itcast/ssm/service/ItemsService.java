package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsService {

	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) throws Exception;
	
	public ItemsCustom queryItemsById(Integer id) throws Exception;
	
	public void updateItems(ItemsCustom itemsCustom) throws Exception;
}
