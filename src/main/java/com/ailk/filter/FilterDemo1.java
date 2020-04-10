package com.ailk.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("111被初始化了！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filterDemo111执行了！");
        chain.doFilter(request,response);
        System.out.println("filterDemo111执行结束啦！");
    }

    @Override
    public void destroy() {
        System.out.println("111被移除啦");
    }
}
