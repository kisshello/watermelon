package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求方式："+request.getMethod());
        System.out.println("客户机IP地址"+request.getRemoteAddr());
        System.out.println("请求参数的字符串"+request.getQueryString());
        System.out.println("请求路径的URL"+request.getRequestURL());
        System.out.println("请求路径的URI"+request.getRequestURI());
        System.out.println("获得客户机浏览器类型"+request.getHeader("User-Agent"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
