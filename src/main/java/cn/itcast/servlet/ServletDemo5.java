package cn.itcast.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType("aa.txt");
        String contextPath = servletContext.getRealPath("");
        System.out.println(mimeType);
        System.out.println("contextPath:::"+contextPath);
        System.out.println("username:::"+servletContext.getInitParameter("usename"));;
        System.out.println("password::"+servletContext.getInitParameter("password"));
        Enumeration<String> enums = servletContext.getInitParameterNames();
        while (enums.hasMoreElements()){
            String name = enums.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println(name+":"+value);;
        }
        System.out.println("---------------------------------------------");
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db1.properties");
        Properties props = new Properties();
        props.load(is);
        String username = props.getProperty("username");
        System.out.println("使用servletContext方式获得文件中的变量username："+username);
        response.getWriter().println("12345");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
