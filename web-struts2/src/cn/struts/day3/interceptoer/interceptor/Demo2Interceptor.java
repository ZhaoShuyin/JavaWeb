package cn.struts.day3.interceptoer.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo2Interceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo2Interceptor 执行前.....");
		String rtValue = invocation.invoke();//放行：让下一个执行
		System.out.println("Demo2Interceptor 执行后.....");
		return rtValue;
	}

}
