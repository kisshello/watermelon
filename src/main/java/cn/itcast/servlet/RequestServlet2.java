package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class RequestServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        String sex = request.getParameter("sex");
        String city = request.getParameter("city");
        System.out.println("性别是"+sex);
        System.out.println("城市是"+city);
        String hobby[] = request.getParameterValues("hobby");
        System.out.println("爱好："+ Arrays.toString(hobby));
        String info = request.getParameter("info");
        System.out.println("自我介绍："+info);
        Map<String,String[]> map = request.getParameterMap();
        System.out.println("//////////////////////////////////////////");
        for(String key:map.keySet()){
            String value[] = map.get(key);
            System.out.println(key+":"+Arrays.toString(value));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
