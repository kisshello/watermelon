package com.JDBC;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo1 {

    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/java/db.properties"));

        }catch (Exception e){
            e.printStackTrace();
        }
        driverClassName = properties.getProperty("driverClassName");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

    }

    @Test
    public void demo4(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///test","root","wanghongkai");
            stmt = conn.createStatement();
            String sql = "update user set name = '456' where id = '5'";
            String sql2 = "update user set nickname = '456' where id = '7'";
            String sql3 = "delete from user where id = '12'";
            stmt.addBatch(sql);
            stmt.addBatch(sql2);
            stmt.addBatch(sql3);
            int number[] = stmt.executeBatch();
            int result = stmt.executeUpdate(sql);
            if(result>0){
                System.out.println("修改用户成功！"+",result="+result+";number="+number);
            }else{
                System.out.println("失败啦！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                try{
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    stmt = null;
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    conn = null;
                }
            }
        }
    }

    @Test
    public void demo3(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName(driverClassName);
            conn = DriverManager.getConnection("jdbc:mysql:///test","root","wanghongkai");
            stmt = conn.createStatement();
            String sql = "insert into user values(null,'张三','三',15)";
            int result = stmt.executeUpdate(sql);
            if(result>0){
                System.out.println("执行成功了！");
                System.out.println(JDBCDemo2.class.getClassLoader().getResource("db.properties").getPath());
            }else{
                System.out.println("失败啦！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null!=stmt){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    stmt = null;
                }
            }
            if(null!=conn){
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

    @Test
    public void  demo1() throws Exception{
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","wanghongkai");
        Statement stat = conn.createStatement();
        String sql = "select * from user";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            System.out.println("[id:"+ rs.getInt("id")+",name:"+rs.getString("name")+",nickname:"+rs.getString("nickname")+",age:"+rs.getInt("age")+"]");
        }
        rs.close();
        stat.close();
        conn.close();;
    }

    @Test
    public void demo2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","wanghongkai");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from user");
            while(rs.next()){
                System.out.println(rs.getInt("id"));;
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(null != rs){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            if(null != stmt){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                stmt = null;
            }
            if(null != conn){
                try{
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
