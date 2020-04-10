package cn.itcast.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        response.getWriter().println("username"+username+"password:"+password);
        Enumeration<String> names = config.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            response.getWriter().println("name==="+value);

            //3、获取servlet的名称
            String servletName = config.getServletName();
            System.out.println("servletName:"+servletName);
        }

    }
}
