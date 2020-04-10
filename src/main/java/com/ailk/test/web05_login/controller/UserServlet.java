package com.ailk.test.web05_login.controller;

import com.ailk.test.web05_login.domain.User;
import com.ailk.test.web05_login.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           request.setCharacterEncoding("UTF-8");
           //接收数据
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           //封装数据
           User user = new User();
           user.setUsername(username);
           user.setPassword(password);
           //处理数据
           UserModel userModel = new UserModel();
           User userExist = userModel.login(user);
           //根据处理结果进行页面跳转
           if(userExist==null){
               //登录失败
               request.setAttribute("msg","用户名或密码错误！");
               request.getRequestDispatcher("/newpages/web05_login/login.jsp").forward(request,response);
           }else{
               //登录成功
               request.getSession().setAttribute("existUser",userExist);
               request.getRequestDispatcher("/newpages/web05_login/success.jsp").forward(request,response);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
