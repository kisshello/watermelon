package com.ailk.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/4/12 18:22
 */
public class GenericEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //在过滤器中增强request对象，并将增强后的request对象传递给Servlet
        HttpServletRequest req = (HttpServletRequest)request;
        MyHttpServletRequest myHttpServletRequest = new MyHttpServletRequest(req);
        chain.doFilter(myHttpServletRequest,response);

    }

    @Override
    public void destroy() {

    }
}