package com.lm.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 龙鸣 on 2017/8/28.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求uri
        String uri=request.getRequestURI();
        System.out.println(uri);

        //如果uri中包含login，放行
        if(uri.indexOf("login")>=0){
            return true;
        }

        HttpSession session=request.getSession();
        //如果已经登录，放行
        if(session.getAttribute("first_name")!=null){
            return true;
        }

        //以上不满足，则需要用户进行登录
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
