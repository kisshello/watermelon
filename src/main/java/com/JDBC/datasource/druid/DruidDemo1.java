package com.JDBC.datasource.druid;


import com.JDBC.JDBCUtils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo1 {


    /**
     * 手动设置参数的方式
     * @throws Exception
     */
    @Test
    public void demo1() throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Properties props = new Properties();
            props.load(new FileInputStream(DruidDemo1.class.getClassLoader().getResource("druid.properties").getPath()));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
            conn = dataSource.getConnection();

            /*DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
            dataSource.setUsername("root");
            dataSource.setPassword("wanghongkai");
            conn = dataSource.getConnection();*/

            //conn=JDBCUtils.getConnection();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
    }
}
