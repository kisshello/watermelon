package com.JDBC.dbutils;

import com.JDBC.JDBCUtils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class DBUtilsDemo1 {

    /**
     * 添加操作
     */
    @Test
    public void demoInsert(){

        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try{
            int n = queryRunner.update("insert into user values(null,?,?,?)","2","3","4");
            System.out.println(n);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 修改操作
     */
    @Test
    public void demoUpdate(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try{
            int result = queryRunner.update("update user set name = ? where id = ?","15","15");
            System.out.println(result);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 删除操作
     */
    @Test
    public void demoDelete(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try {
            int result = queryRunner.update("delete from user where id = ?","16");
            System.out.println(result);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
