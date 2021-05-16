package com.zsy.ssm.utils.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {

		System.out.println("================ CustomHandlerExceptionResolver =============== ");

		exception.printStackTrace();

		CustomException customException = null;
		if(exception instanceof CustomException){
			customException = (CustomException) exception;
		}else {
			customException = new CustomException("未知错误");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.setViewName("view");
		return modelAndView;
	}

}