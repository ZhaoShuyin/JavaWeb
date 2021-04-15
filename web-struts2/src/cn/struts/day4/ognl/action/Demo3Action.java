package cn.struts.day4.ognl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 */
public class Demo3Action extends ActionSupport {
	private String[] strs;//数组
	private List<String> list;//列表
	private Set<String> set;//Set
	private Map<String,String> map;//map
	
	public String execute(){
		strs = new String[]{"a","b","c"};
		list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		set = new HashSet<String>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		
		map = new HashMap<String, String>();
		map.put("a", "aaaa");
		map.put("b", "bbbb");
		map.put("c", "cccc");
		return SUCCESS;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
}
