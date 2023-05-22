package org.hopu.djp.libDemo.utils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Druid连接池的工具类
 */
public class DruidHelper {
    //1、定义成员变量DataSource
    private static DataSource ds;

    static {
        try {
            //1、加载配置文件
            Properties pro = new Properties();
            pro.load(DruidHelper.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2、获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() {
        Connection conn = null;
        if(ds != null) {
            try {
                conn = ds.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource() {
        return ds;
    }
}
