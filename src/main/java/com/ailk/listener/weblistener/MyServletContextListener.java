package com.ailk.listener.weblistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener监听器
 * 事件源：ServletContext
 * 监听器：MyServletContextListener
 * 事件源和监听器绑定：通过配置方式绑定，在web.xml中
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    //监听ServletContext对象的创建
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被创建了，监听器监听成功");
    }

    @Override
    //监听ServletContext对象的销毁
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了，监听器执行完毕");
    }

    /**
     *
     * @description: 测试添加的方法注释的template
     * @author: wanghk3
     * @time: 2020/4/5
     */
    public void test(int id, String name) {

    }

}
