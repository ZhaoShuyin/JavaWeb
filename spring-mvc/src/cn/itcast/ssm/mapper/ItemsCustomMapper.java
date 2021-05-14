package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsCustomMapper {
	
	public List<ItemsCustom> queryItems(ItemsQueryVo itemsQueryVo) throws Exception;

}
