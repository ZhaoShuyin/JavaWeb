package cn.itcast.mybatis.po;

import java.util.List;
import java.util.Map;

public class UserQueryVo {
	
	private UserCustom userCustom;
	
	private Map<String, String> map;
	
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	// 其他信息
	
}
