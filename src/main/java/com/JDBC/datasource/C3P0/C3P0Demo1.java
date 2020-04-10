package com.JDBC.datasource.C3P0;

import com.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C3P0Demo1 {

    /**
     * 采用配置文件的方式
     */
    @Test
    public void demo2(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            conn = dataSource.getConnection();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }

    }

    /**
     * 手动配置参数的方式
     */
    @Test
    public void demo1(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///test");
            dataSource.setUser("root");
            dataSource.setPassword("wanghongkai");
            conn = dataSource.getConnection();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }

    }
}
