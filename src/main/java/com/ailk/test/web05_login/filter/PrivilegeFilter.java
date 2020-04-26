package com.ailk.test.web05_login.filter;

import com.ailk.test.web05_login.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:权限验证的过滤器
 * @author: wanghk3
 * @time: 2020/4/6 21:15
 */
public class PrivilegeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("web05_login拦截器创建啦");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //判断用户是否已经登录
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getRequestURL());
        User existUser = (User)httpServletRequest.getSession().getAttribute("existUser");
        //判断
        /*if(existUser==null){
            //没有登录
            request.setAttribute("msg","您还没有登录！没有权限访问！");
            request.getRequestDispatcher("/newpages/web05_login/login.jsp").forward(request,response);
        }else{
            //已经登录
            chain.doFilter(request, response);
        }*/

    }

    @Override
    public void destroy() {
        System.out.println("web05_login销毁啦");
    }
}