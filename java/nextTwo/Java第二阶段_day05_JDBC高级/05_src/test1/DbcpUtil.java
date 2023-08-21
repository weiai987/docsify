package test1;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;


public class DbcpUtil {
    private static DataSource dataSource = null;
    //创建数据库连接池
    static{
        Properties properties = new Properties();
        try {
            ClassLoader classLoader=DbcpUtil.class.getClassLoader();
            properties.load(classLoader.getResourceAsStream("dbcp.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("DBCP始化错误，请检查配置文件");
        }
    }

    //创建连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接错误");
        }
    }

    //释放连接
    public static void releaseConnection(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
