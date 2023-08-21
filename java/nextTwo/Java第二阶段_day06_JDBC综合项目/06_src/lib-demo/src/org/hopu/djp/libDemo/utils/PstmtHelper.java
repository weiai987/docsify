package org.hopu.djp.libDemo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 预处理SQL工具类
 */
public class PstmtHelper {

    public static PreparedStatement createPstmt(Connection conn, String sql, Object[] params) {
        //接受预处理SQL与参数数组，已被后期执行
        PreparedStatement pstmt = null;
//        System.out.println("sql=" + sql);
//        if(params != null) {
//            for(Object x: params) {
//                System.out.println("param=" + x);
//            }
//        }

        try {
            pstmt = conn.prepareStatement(sql);
            if(params != null) {
                for(int i=0; i<params.length; i++) {
                    Object param = params[i];
//                    System.out.println(param);
                    if(param == null) {
//                        System.out.println("param is null");
                        pstmt.setObject(i+1, null);
                    } else if(param instanceof String) {
                        pstmt.setString(i+1, (String)param);
                    } else if(param instanceof Date) {
                        Date d = (Date)param;
                        pstmt.setDate(i+1, new java.sql.Date(d.getTime()));
                    } else if(param instanceof LocalDateTime) {
                        LocalDateTime d = (LocalDateTime)param;
                        java.sql.Timestamp t = new java.sql.Timestamp(
                                Date.from(d.atZone(ZoneId.systemDefault()).toInstant()).getTime());
                        pstmt.setTimestamp(i+1, t);
                    } else if(param instanceof Long) {
                        pstmt.setLong(i+1, (Long)param);
                    }  else if(param instanceof Integer) {
                        pstmt.setInt(i+1, (Integer)param);
                    } else if(param instanceof Double) {
                        pstmt.setDouble(i+1, (Double) param);
                    } else if(param instanceof Boolean) {
                        pstmt.setBoolean(i+1, (Boolean) param);
                    } else {
//                        System.out.println("can not find any type.");
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pstmt;
    }
}
