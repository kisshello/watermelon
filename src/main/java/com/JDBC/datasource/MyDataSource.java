package com.JDBC.datasource;

import com.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {

    //将一些链接存储到内存中，可以定义一个集合，用于存储链接对象
    private List<Connection> connList = new ArrayList<Connection>();

    public List<Connection> getConnList() {
        return connList;
    }

    public void setConnList(List<Connection> connList) {
        this.connList = connList;
    }

    //初始化的时候提供一些链接
    public MyDataSource(){
        for(int i=0;i<3;i++){
            connList.add(JDBCUtils.getConnection());
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = connList.remove(0);
        return conn;
    }

    //编写一个归还链接的办法
    public void addBack(Connection conn){
        connList.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
