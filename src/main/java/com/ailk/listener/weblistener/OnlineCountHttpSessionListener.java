package com.ailk.listener.weblistener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/4/5 17:17
 */
public class OnlineCountHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //在线了
        //获得原来的值
        HttpSession httpSession = se.getSession();
        System.out.println(httpSession.getId()+"上线了...");
        Integer count = Integer.parseInt(httpSession.getServletContext().getAttribute("count").toString());
        count++;
        httpSession.getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession httpSession = se.getSession();
        Integer count = Integer.parseInt(httpSession.getServletContext().getAttribute("count").toString());
        count--;
        httpSession.getServletContext().setAttribute("sount",count);
    }
}