package com.ssm.mapper;

import java.util.List;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;

public interface ItemsCustomMapper {
	
	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) throws Exception;

}
