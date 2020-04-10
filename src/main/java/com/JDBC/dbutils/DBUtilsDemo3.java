package com.JDBC.dbutils;

import com.JDBC.JDBCUtils.JDBCUtils2;
import com.JDBC.dbutils.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ResultSetHandler的实现类
 */
public class DBUtilsDemo3 {

    /**
     * ArrayList：将一条记录封装到一个Object数组中
     */
    @Test
    public void demo1(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try {
           Object objs[] = queryRunner.query("select * from user where id = ?",new ArrayHandler(),15);
            System.out.println(Arrays.toString(objs));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * ArrayListHandler：将多条记录封装到一个装有Object数组的List集合中
     * 一条记录封装到一个Object[]数组中，多条记录就是多个Object[]数组中，那么多个Object[]数组就将其装入List集合中即可
     */
    @Test
    public void demo2(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try{
            String sql = "select * from user";
            List<Object[]> list = queryRunner.query(sql,new ArrayListHandler());
            for(Object[] objects:list){
                System.out.println(Arrays.toString(objects));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * BeanHandler：将一条记录封装到一个JavaBean中
     */
    @Test
    public void demo3(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try {
            User user = queryRunner.query("select * from user where id = ?",new BeanHandler<User>(User.class),2);
            System.out.println(user.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * BeanListHandler：将多条记录封装到一个装有JavaBean的List的集合中
     * 一个记录就是一个JavaBean的对象，多个记录就是多个JavaBean的对象，将多个JavaBean对象装到一个list集合中
     */
    @Test
    public void demo4(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try {
            List<User> list = queryRunner.query("select * from user",new BeanListHandler<User>(User.class));
            for (User user:list){
                System.out.println(user.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * MapHandler：将一个记录封装到一个Map中，map的key是列名，map的value是表中的记录值
     */
    @Test
    public void demo5(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
                try{
                    Map<String,Object> map = queryRunner.query("select * from user where id = ?",new MapHandler(),"3");
                    for(String key:map.keySet()){
                        System.out.println(key+":"+map.get(key));
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
    }

    /**
     * MapListHandler:将多条记录封装到一个装有Map的List集合中
     */
    @Test
    public void demo6(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try {
            List<Map<String,Object>> list = queryRunner.query("select * from user",new MapListHandler());
            for(Map<String,Object> map:list){
                for(String key:map.keySet()){
                    System.out.println(key+":"+map.get(key));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * columnListHandler：将某列的值封装到list集合中
     */
    @Test
    public void demo7(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try {
            List<Object> list = queryRunner.query("select name,age from user",new ColumnListHandler("name"));
            for (Object o : list){
                System.out.println(o);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * ScalarHandler:单值封装
     */
    @Test
    public void demo8(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try {
            Object obj = queryRunner.query("select count(1) from user",new ScalarHandler());
            System.out.println(obj);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
