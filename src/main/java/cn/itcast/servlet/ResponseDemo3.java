package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        outputStream.write("中文".getBytes("UTF-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("这是response的set缓冲区的显示中文的测试呢！");
        doPost(request,response);
    }
}
