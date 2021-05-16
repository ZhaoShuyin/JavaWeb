package com.zsy.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title com.zsy.ssm.interceptor
 * @date 2021/5/16
 * @autor Zsy
 */

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("111 ========== preHandle() \n " +
                "handler : "+handler.getClass().getName()
        );
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("222 ========== postHandle()" +
                "\nhandler : "+handler.getClass().getName() +
                "\n modelAndView :"+modelAndView.getClass().getName()
        );
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("333 ========== afterCompletion()" +
                "\nhandler : "+handler.getClass().getName() +
                "\n ex :"+ex.getClass().getName()
        );
    }
}
