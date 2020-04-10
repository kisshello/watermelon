package com.ailk.listener.weblistener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听HTTPSession创建和销毁的监听器
 */
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("httpSession创建了，监听器监听成功啦");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("httpSession被销毁啦，监听器执行完毕");
    }
}
