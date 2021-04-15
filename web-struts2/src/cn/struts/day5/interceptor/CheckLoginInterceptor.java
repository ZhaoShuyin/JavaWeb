package cn.struts.day5.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor {

	public String doIntercept(ActionInvocation invocation) throws Exception {
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		Object obj = session.getAttribute("user");//登陆标记
		
		Object obj = ActionContext.getContext().getSession().get("user");
		if(obj==null){
			//没有登陆
			return Action.LOGIN;
		}
		return invocation.invoke();//放行
	}

}
