package com.ailk.listener.weblistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/4/5 17:15
 */
public class OnlineCountServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //在服务启动的时候初始化一个值为0

        //还需要将这个值存入到ServletContext中
        sce.getServletContext().setAttribute("count",0);;
        System.out.println();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}