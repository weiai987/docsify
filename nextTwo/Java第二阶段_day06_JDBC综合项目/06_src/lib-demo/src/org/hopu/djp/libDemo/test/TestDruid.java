package org.hopu.djp.libDemo.test;

import org.hopu.djp.libDemo.utils.DruidHelper;
import org.hopu.djp.libDemo.utils.PstmtHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDruid {
    public static void test1() {
        Connection conn = DruidHelper.getConnection();
        if(conn == null) {
            System.out.println("conn is null.");
        }
        String sql = "select * from t_dict where did=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, 3);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("dvalue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidHelper.close(rs, pstmt, conn);
        }
    }

    public static void test2() {
        Connection conn = DruidHelper.getConnection();
        if(conn == null) {
            System.out.println("conn is null.");
        }
        String sql = "select * from t_dict where did=?";
        List<Object> params = new ArrayList<Object>();
        params.add(Long.parseLong("3"));
        PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql, params.toArray());
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("dvalue"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidHelper.close(rs, pstmt, conn);
        }
    }

    public static void main(String[] args) {
        TestDruid.test2();
    }
}
