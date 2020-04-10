package com.ailk.test.web05_login.model;

import com.JDBC.JDBCUtils.JDBCUtils2;
import com.ailk.test.web05_login.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/4/6 20:48
 */
public class UserModel {
    public User login(User user) throws Exception{
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        String sql = "select * from user_login where username = ? and password = ?";
        User existUser = queryRunner.query(sql,new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
        return existUser;
    }
}