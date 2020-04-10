package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class RequestServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String name = request.getParameter("username");
        System.out.println("name:"+name);*/
        request.setCharacterEncoding("UTF-8");
        String nameAfter = request.getParameter("username");
        System.out.println("nameAfter:"+nameAfter);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        System.out.println("color:"+color);
        String encodeColor = URLEncoder.encode(color,"ISO-8859-1");
        System.out.println("encodeColor:"+encodeColor);
        String decodeColor = URLDecoder.decode(encodeColor,"UTF-8");
        System.out.println("decodeColor:"+decodeColor);
        String stringColor = new String(color.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println("stringColot:"+stringColor);
    }
}
