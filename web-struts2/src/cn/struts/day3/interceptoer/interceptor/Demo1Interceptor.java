package cn.struts.day3.interceptoer.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo1Interceptor extends AbstractInterceptor {
	
	/*
	 * 对于拦截范围内的所有动作访问都会经过该方法
	 * 参数：ActionInvocation invocation （动作调用） 封装了当前动作调用用到的所有信息
	 * 返回值：String。对应的是一个逻辑结果视图
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo1Interceptor 执行前.....");
		String rtValue = invocation.invoke();//放行：让下一个执行
		System.out.println("Demo1Interceptor 执行后.....");
		return rtValue;
	}

}
