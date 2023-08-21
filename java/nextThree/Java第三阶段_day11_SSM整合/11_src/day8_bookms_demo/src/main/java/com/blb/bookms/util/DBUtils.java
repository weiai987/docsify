package com.blb.bookms.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库工具类
 */
public class DBUtils {

    //创建连接池对象
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    //连接对象
    private static Connection connection = null;

    /**
     * 返回连接对象
     * @return
     */
    public static Connection getConnection(){
        if(connection == null){
            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookms_db",
//                        "root","root");
                connection = dataSource.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 关闭连接
     */
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 增删改
     * @param sql
     * @param args
     * @return
     */
    public static int update(String sql,Object... args){
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                preparedStatement.setObject(i + 1,args[i]);
            }
            int count = preparedStatement.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection();
        }
        return 0;
    }

    /**
     * 执行查询获得结果集
     * @param sql
     * @param args
     * @return
     */
    public static ResultSet executeResultSet(String sql, Object... args){
        //使用结果集时，连接不能关闭
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                preparedStatement.setObject(i + 1,args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询集合
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    //ResultSet ---> List<Book>
    //数据库字段和实体类字段名一样
    public static <T> List<T> executeQuery(Class clazz,String sql,Object... args){
        //获得结果集
        try {
            List<T> list = new ArrayList<>();
            ResultSet resultSet = executeResultSet(sql, args);
            //循环读取结果集的每一行
            while (resultSet.next()) {
                //反射创建实体类对象
                Object obj = clazz.newInstance();
                //将实体类中所有字段获得
                Field[] fields = clazz.getDeclaredFields();
                //遍历字段
                for(Field field : fields){
                    //通过字段名
                    String fName = field.getName();
                    //读取字段上的DBField注解
                    DBField dbf = field.getDeclaredAnnotation(DBField.class);
                    if(dbf != null){
                        if(!dbf.exists()){
                            //如果配置为不存在就跳过
                            continue;
                        }
                        if(dbf.fieldName().length() > 0){
                            //使用配置的字段名
                            fName = dbf.fieldName();
                        }
                    }
                    //获得结果集中某一列的数据
                    Object value = resultSet.getObject(fName);
                    //对象.字段 = 值
                    //设置字段的可见性
                    field.setAccessible(true);
                    //给字段赋值
                    field.set(obj,value);
                }
                //添加到集合
                list.add((T) obj);
            }
            return list;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }
        return null;
    }

    /**
     * 查询数量
     * @param sql
     * @param args
     * @return
     */
    public static int queryCount(String sql,Object... args){
        int count = 0;
        ResultSet resultSet = executeResultSet(sql, args);
        try {
            if (resultSet.first()) {
                count = resultSet.getInt(1);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }
        return count;
    }
}
