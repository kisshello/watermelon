package com.utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(JDBCUtils.class.getClassLoader().getResource("db.properties").getPath()));
        }catch (Exception e){
            e.printStackTrace();
        }
        driverClassName = props.getProperty("driverClassName");
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");
    }

    /**
     * 注册新驱动
     */
    public static  void loadDriver(){
        try {
            Class.forName(driverClassName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获得连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            loadDriver();
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Statement stmt,Connection conn){
        if(stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs,PreparedStatement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

}
