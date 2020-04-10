package com.JDBC;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo2 {

    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        Properties props = new Properties();
        try{
            props.load(new FileInputStream(JDBCDemo2.class.getClassLoader().getResource("db.properties").getPath()));
        }catch (Exception e){
            e.printStackTrace();
        }
        driverClassName = props.getProperty("driverClassName");
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");
    }

    @Test
    public void demo1(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url,username,password);
            String sql = "select * from user where name = ? and nickname = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"456");;
            pstmt.setString(2,"1");
            rs = pstmt.executeQuery();
            while (rs.next()){
               flag = true;
            }
            if(flag){
                System.out.println("登录成功！");
            }else {
                System.out.println("失败啦！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != rs){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    rs = null;
                }
            }
            if(null != pstmt){
                try {
                    pstmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    pstmt = null;
                }
            }
            if(null != conn){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    conn = null;
                }
            }
        }

    }

}
