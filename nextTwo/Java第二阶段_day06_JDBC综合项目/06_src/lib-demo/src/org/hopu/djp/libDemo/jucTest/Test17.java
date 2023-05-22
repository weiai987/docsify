package org.hopu.djp.libDemo.jucTest;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Test17 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examdb", "tl", "Tlpwd_1234");
//        Statement statement = connection.createStatement();
        String sql = "select * from demo_user";
//        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            System.out.print("userid=" + resultSet.getString("userid") + ", ");
            System.out.print("username=" + resultSet.getString("username") + ", ");
            System.out.println("password=" + resultSet.getString("password"));
        }

        resultSet.close();
//        statement.close();
        preparedStatement.close();
        connection.close();

    }
}
