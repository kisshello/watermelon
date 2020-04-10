package com.ailk.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * filterConfig的演示
 */
public class FilterDemo4 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterName = filterConfig.getFilterName();
        System.out.println(filterName);
        System.out.println("444初始化啦");
        String username = filterConfig.getInitParameter("username");
        String password = filterConfig.getInitParameter("password");
        System.out.println(username+"==="+password);
        Enumeration<String> enums = filterConfig.getInitParameterNames();
        while (enums.hasMoreElements()){
            String key = enums.nextElement();
            System.out.println(key+":==="+filterConfig.getInitParameter(key));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("444开始执行啦！");
        chain.doFilter(request, response);
        System.out.println("444执行结束啦！");
    }

    @Override
    public void destroy() {
        System.out.println("444销毁啦！");
    }
}
