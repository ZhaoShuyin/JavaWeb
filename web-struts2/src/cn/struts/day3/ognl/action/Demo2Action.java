package cn.struts.day3.ognl.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 熟悉ActionContext中的API
 */
public class Demo2Action extends ActionSupport {
	public String execute(){

        /**
         * 如何获取ActionContext的实例
         */
		ActionContext ac = ActionContext.getContext();      //从当前线程上获取的

		Map<String,Object> contextMap = ac.getContextMap(); //得到contextMap
		
		ac.put("key1", "value1");//向contextMap中存放数据.p=p1
		
		Map<String, Object> sessionScope = ac.getSession();
		sessionScope.put("key2", "session-value");//向会话范围存放数据
		
		Map<String, Object> applicationScope = ac.getApplication();
		applicationScope.put("key3", "application-value");//向应用范围存放数据
		
		return SUCCESS;
	}
}
