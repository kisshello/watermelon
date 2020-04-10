package com.ailk.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("333被初始化了！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filterDemo333执行了！");
        chain.doFilter(request,response);
        System.out.println("filterDemo333执行结束啦！");
    }

    @Override
    public void destroy() {
        System.out.println("333被移除啦");
    }
}
