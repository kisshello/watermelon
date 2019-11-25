package cn.itcast.ssm.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemsController2 implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置模型数据
        request.setAttribute("12",12);
        request.getRequestDispatcher("").forward(request,response);

        //使用此方法可以设置response的响应模式，比如响应json数据
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json串");
    }
}
