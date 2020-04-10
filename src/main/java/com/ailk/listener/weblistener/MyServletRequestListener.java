package com.ailk.listener.weblistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/4/5 17:03
 */
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("servletRequest被销毁了");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("servletRequest对象被创建Lee");
    }
}