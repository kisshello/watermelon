package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletResponse1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setStatus(302);
        //response.setHeader("Location","/watermelon/ServletResponse2");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("这里是ServletDemo1,5秒后跳转到ServletDemo2！");
        response.setHeader("Refresh","5;url=/watermelon/ServletResponse2");
    }
}
