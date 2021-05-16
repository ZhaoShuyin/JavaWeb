package cn.itcast.ssm.po;

import java.util.List;

/**
 * 包装类型的pojo
 * @author JD
 *
 */
public class ItemsQueryVo {
	
	private ItemsCustom itemsCustom;
	
	private List<ItemsCustom> itemList;
	
	public List<ItemsCustom> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemsCustom> itemList) {
		this.itemList = itemList;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
	

}
