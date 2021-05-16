package cn.itcast.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.utils.group.GroupA;
import cn.itcast.ssm.utils.group.GroupB;

@Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Resource
	private ItemsService itemsService;
	
	@ModelAttribute("itemsType")
	public Map<String, String> itemsType(){
		Map<String, String> itemsType = new HashMap<String, String>();
		
		itemsType.put("t001", "大家电");
		itemsType.put("t002", "母婴");
		return itemsType;
	}
	
	/**
	 * 查询商品列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception{
		
		System.out.println("2---queryItems");
		
		// 查询商品列表信息
		List<ItemsCustom> itemsList = itemsService.queryItems(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	/**
	 * 修改商品
	 * @param model
	 * @param items_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editItems")
	public String editItems(Model model,@RequestParam(value="id",defaultValue="2") Integer items_id) throws Exception{
		ItemsCustom itemsCustom = itemsService.queryItemsById(items_id); // 参数绑定 没讲   静态数据
		model.addAttribute("items", itemsCustom);
		return "items/editItems";
	}
	
	/**
	 * 更新商品
	 * @param itemsCustom
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateItems")
	public String updateItems(HttpServletRequest request,
			Model model,@Validated(value={GroupA.class,GroupB.class}) 
			//@ModelAttribute("items") 
			ItemsCustom itemsCustom,BindingResult bindingResult,
			MultipartFile pictureFile) throws Exception{
		
		// 附件上传
		if(pictureFile!=null && pictureFile.getSize()>0){
			// 上传文件的名称
			String fileName = pictureFile.getOriginalFilename();
			String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
			
			// 定义新的附件名称
			String fileNewName = UUID.randomUUID().toString().replace("-", "")+fileSuffix;
			
			File file = new File("F:\\upload\\pic\\"+fileNewName);
			//  附件上传
			pictureFile.transferTo(file);
			itemsCustom.setPic(fileNewName);
		}
		
		if (bindingResult.hasErrors()) { // 有错误
			List<ObjectError> objectErrors = bindingResult.getAllErrors();
			model.addAttribute("objectErrors", objectErrors);
			
			model.addAttribute("items", itemsCustom);
			return "items/editItems";
		}
		
		itemsService.updateItems(itemsCustom);
		return "redirect:queryItems.action";
	}
	
	/**
	 * 批量删除  绑定数组
	 * @param itemIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBatchItems")
	public String deleteBatchItems(Integer[] itemIds) throws Exception{
		System.out.println("选择的商品个数是："+itemIds.length);
		return "success";
	}
	
	/**
	 * 批量修改
	 * @param model
	 * @param itemIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editBatchItems")
	public String editBatchItems(Model model, Integer[] itemIds) throws Exception{
		List<ItemsCustom> itemsList = itemsService.queryItems(null);
		model.addAttribute("itemsList", itemsList);
		return "items/editBatchItems";
	}
	
	/**
	 * 批量更新  绑定List集合
	 * @param itemsQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBatchItems")
	public String updateBatchItems(ItemsQueryVo itemsQueryVo) throws Exception{
		
		return "success";
	}

}
