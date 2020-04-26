package com.ailk.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * @description: 增强的类
 * @author: wanghk3
 * @time: 2020/4/12 18:25
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public MyHttpServletRequest(HttpServletRequest request){
        super(request);
        this.request = request;
    }

    //增强request.getParameter()方法

    @Override
    public String getParameter(String name) {
        //获得请求方式
        String method = request.getMethod();
        //根据get还是post请求进行不同方式的编码的处理
        if("GET".equalsIgnoreCase(method)){
            //get方式的请求
            String value = super.getParameter(name);
            try {
                value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
            return value;
        }else if("POST".equalsIgnoreCase(method)){
            //post方式的请求
            try {
                request.setCharacterEncoding("UTF-8");
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        return super.getParameter(name);
    }
}