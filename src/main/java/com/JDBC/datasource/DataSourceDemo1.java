package com.JDBC.datasource;

import com.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataSourceDemo1 {
    @Test
    public void demo1(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MyDataSource myDataSource = null;
        try{
            myDataSource = new MyDataSource();
            System.out.println("使用之前链接的个数是："+myDataSource.getConnList().size());
            conn = myDataSource.getConnection();
            String sql = "SELECT * FROM user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
            }
            System.out.println("使用中链接的个数是："+myDataSource.getConnList().size());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
            myDataSource.addBack(conn);
            System.out.println("使用之后链接的个数是："+myDataSource.getConnList().size());
        }
    }
}
