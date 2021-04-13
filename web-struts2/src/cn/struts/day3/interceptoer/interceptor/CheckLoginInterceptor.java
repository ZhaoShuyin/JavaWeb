package cn.struts.day3.interceptoer.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//检查用户是否登陆的拦截器
//登陆了：放行
//没有登陆：登陆页面
public class CheckLoginInterceptor extends MethodFilterInterceptor {
    /**
     * Intercept
     * doIntercept
     */
    public String doIntercept(ActionInvocation invocation) throws Exception {
        //获取HttpSession
        HttpSession session = ServletActionContext.getRequest().getSession();
        //取出登陆标记
        Object flag = session.getAttribute("user");
        //判断
        if (flag == null)
            return "login";//登陆的逻辑视图
        //不为空，放行
        return invocation.invoke();
    }

}
