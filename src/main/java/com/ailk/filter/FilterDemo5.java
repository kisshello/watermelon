package com.ailk.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo5 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filterDemo5开始拦截啦");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
