package cn.itcast.ssm.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	/**
	 * 执行Controller方法前执行该该方法
	 * 
	 * 使用场景：可进行一些初始化操作   权限信息加载
	 * 
	 * return false：不放行  true：放行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		
		// 1、如果是登录，放行
		String uri = request.getRequestURI();
		if(uri.lastIndexOf("login.action")>0){ 
			return true;
		}
		
		// 2、其他请求
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username!=null && !equals(username)){ // 有登录信息，放行
			return true;
		}
		
		// 踢回登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	/**
	 * 执行Controller方法后执行
	 * 
	 * 使用场景：modelAndView的数据更改
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
		System.out.println("3---postHandle");

	}

	/**
	 * 最后执行
	 * 
	 * 使用场景：释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("4---afterCompletion");

	}
	

}
