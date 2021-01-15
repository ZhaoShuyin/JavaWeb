package com.zsy.ajax.jsontest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.junit.Test;

import com.zsy.ajax.domain.User;


/**
 * json lib的使用
 * @author zhy
 *
 */
public class JSONTest {

	//转数组
	@Test
	public void test1(){
		String[] strs = {"aaa","bbb","ccc"};
		//使用JSONArray对象的fromObject方法把数组转换成一个JSONArray对象
		JSONArray ja = JSONArray.fromObject(strs);
		//输出
		System.out.println(ja.toString());
	}

	//转list
	@Test
	public void test2(){
		List<String> slist = new ArrayList<String>();
		slist.add("hello1");
		slist.add("hello2");
		slist.add("hello3");
		JSONArray ja = JSONArray.fromObject(slist);
		System.out.println(ja);
	}

	//转set
	@Test
	public void test3(){
		Set<String> set = new HashSet<String>();
		set.add("haha");
		set.add("hehe");
		set.add("heihei");
		JSONArray ja = JSONArray.fromObject(set);
		System.out.println(ja);
	}

	//转map 转成array的形式
	@Test
	public void test4(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("AAA", "123");
		map.put("BBB", "456");
		map.put("CCC", "789");
		JSONArray ja = JSONArray.fromObject(map);
		System.out.println(ja);
	}

	//转map，key=value的形式
	@Test
	public void test5(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("AAA", "123");
		map.put("BBB", "456");
		map.put("CCC", "789");
		//使用JSONObject的fromObject方法，获取JSONObject对象
		JSONObject jo = JSONObject.fromObject(map);
		System.out.println(jo);
	}


	//转javabean key=value的形式
	@Test
	public void test6(){
		User user = new User("test","male",20);
		JSONObject jo = JSONObject.fromObject(user);
		System.out.println(jo);
	}

	//转集合，里面的元素是javabean   大括号内是Key=value 中括号内是数组
	@Test
	public void test7(){
		User user1 = new User("test1","male",21);
		User user2 = new User("test2","male",22);
		User user3 = new User("test3","male",23);
		List<User> ulist = new ArrayList<User>();
		ulist.add(user1);
		ulist.add(user2);
		ulist.add(user3);
		JSONArray ja = JSONArray.fromObject(ulist);
		System.out.println(ja);
	}

	//带有过滤条件的生成json数据
	@Test
	public void test8(){
		User user1 = new User("test1","male",21);
		User user2 = new User("test2","male",22);
		User user3 = new User("test3","male",23);
		List<User> ulist = new ArrayList<User>();
		ulist.add(user1);
		ulist.add(user2);
		ulist.add(user3);
		//使用JsonConfig对象，配置需要生成哪些内容
		JsonConfig jc = new JsonConfig();
		//设置排除哪些字段
		jc.setExcludes(new String[]{"age","gender"});
		//创建jsonarray对象
		JSONArray ja = JSONArray.fromObject(ulist, jc);
		System.out.println(ja);
	}
}
