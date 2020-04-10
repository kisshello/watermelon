package cn.itcast.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = this.getServletContext();

        //通过request获取cookies
        Cookie[] cookies = request.getCookies();
        Cookie cookie = this.getCookie(cookies);
        Date date = new Date();
        if(null==cookie){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("这是第一次访问Servlet，没有上次访问");
        }else{













            String value = cookie.getValue();
            response.getWriter().println("上次访问Servlet的时间是："+value);
        }
        Cookie cookie1 = new Cookie("lastVisit",date.toLocaleString());
        cookie1.setPath("/watermelon");
        cookie1.setMaxAge(60*60);
        response.addCookie(cookie1);
    }

    /**
     * 看cookies里是否有lastVisit
     *
     */
    public Cookie getCookie(Cookie[] cookies){
        if(null==cookies){
            return null;
        }else{
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("lastVisit")){
                    return cookie;
                }
            }
        }
        return null;
    }
}
