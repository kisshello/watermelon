package com.JDBC.dbutils;

import com.JDBC.JDBCUtils.JDBCUtils2;
import com.JDBC.dbutils.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtilsDemo2 {

    /**
     * 查询一条
     */
    @Test
    public void demo1(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try{
            User user = queryRunner.query("select * from user where id = ?", new ResultSetHandler<User>() {
                @Override
                public User handle(ResultSet resultSet) throws SQLException {
                    User user = new User();
                    while (resultSet.next()){
                        user.setId(resultSet.getInt("id"));
                        user.setAge(resultSet.getInt("age"));
                        user.setName(resultSet.getString("name"));
                        user.setNickname(resultSet.getString("nickName"));
                    }
                    return user;
                }
            },15);

            System.out.println(user.toString());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 多条查询
     */
    @Test
    public void demo2(){
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        try{
            List<User> list = queryRunner.query("select * from user where id > ?", new ResultSetHandler<List<User>>() {
                @Override
                public List<User> handle(ResultSet resultSet) throws SQLException {
                    List<User> list = new ArrayList<>();
                    while (resultSet.next()){
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setNickname(resultSet.getString("nickname"));
                        user.setName(resultSet.getString("name"));
                        user.setAge(resultSet.getInt("age"));
                        list.add(user);
                    }
                    return list;
                }
            }, 6);
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
