package com.ailk.listener.weblistener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/4/5 17:38
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("向session中添加了属性");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("从session中移除了属性");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session中的属性被替换了");
    }
}