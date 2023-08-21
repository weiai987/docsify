package org.hopu.djp.libDemo.dao.impl;

import org.hopu.djp.libDemo.dao.IUserDao;
import org.hopu.djp.libDemo.entity.BaseEntity;
import org.hopu.djp.libDemo.entity.User;
import org.hopu.djp.libDemo.utils.DruidHelper;
import org.hopu.djp.libDemo.utils.PstmtHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户dao实现类
 */
public class UserDaoImpl implements IUserDao {
    private String getAllField() {
        StringBuffer result = new StringBuffer("user_name,");
        result.append("user_password,");
        result.append("user_realname,");
        result.append("user_type,");
        return result.toString();
    }

    @Override
    public int addOne(User user, int oprId) {
        int result = 0;
        StringBuffer sql = new StringBuffer("insert into lib_user(");
        sql.append(this.getAllField()).append(BaseEntity.getBaseField());
        sql.append(") values (");
        for(int i=0; i<10; i++) {
            sql.append("?");
            if(i < 9)
                sql.append(",");
        }
        sql.append(")");

        Connection conn = DruidHelper.getConnection();
        List<Object> paramList = new ArrayList<Object>();
        paramList.add(user.getUserName());
        paramList.add(user.getUserPassword());
        paramList.add(user.getUserRealname());
        paramList.add("普通用户");

        paramList.add(LocalDateTime.now());
        paramList.add(oprId);
        paramList.add(null);
        paramList.add(null);
        paramList.add(Boolean.TRUE);
        paramList.add(Boolean.FALSE);

        PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
        try {
            if(pstmt != null)
                result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
//            throwables.printStackTrace();
        } finally {
            DruidHelper.close(pstmt, conn);
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int userId) {
        return null;
    }

    @Override
    public List<User> findList(User user) {
        List<User> result = new ArrayList<User>();
        StringBuffer sql = new StringBuffer("select * from lib_user where ");
        sql.append("enable_flag=? and delete_flag=?");
        List<Object> paramList = new ArrayList<Object>();
        paramList.add(User.EnableFlag_enable);
        paramList.add(User.DeleteFlag_undel);
        if(user != null) {
            if(user.getUserName() != null && !"".equals(user.getUserName().trim())) {
                sql.append(" and user_name=? ");
                paramList.add(user.getUserName());
            }
            if(user.getUserPassword() != null && !"".equals(user.getUserPassword().trim())) {
                sql.append(" and user_password=? ");
                paramList.add(user.getUserPassword());
            }
        }

        Connection conn = DruidHelper.getConnection();
        PreparedStatement pstmt = PstmtHelper.createPstmt(conn, sql.toString(), paramList.toArray());
        try {
            if(pstmt != null) {
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    result.add(toUser(rs));
                }
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
//            throwables.printStackTrace();
        } finally {
            DruidHelper.close(pstmt, conn);
        }
        return result;
    }

    @Override
    public int editOne(User user, int oprId) {
        return 0;
    }

    @Override
    public int delOneById(int userId, int oprId) {
        return 0;
    }

    @Override
    public int enableById(int userId, Boolean b, int oprId) {
        return 0;
    }

    @Override
    public User toUser(ResultSet rs) {
        if(rs == null) {
            return null;
        }
        User result = new User();
        try {
            // 处理业务字段
            result.setUserId(rs.getInt("user_id"));
            result.setUserName(rs.getString("user_name"));
            result.setUserPassword(rs.getString("user_password"));
            result.setUserAddress(rs.getString("user_address"));
            result.setUserRealname(rs.getString("user_realname"));
            result.setUserType(rs.getString("user_type"));

            // 处理基础字段
            Date cd = rs.getTimestamp("create_time");
            if(cd != null) {
                result.setCreateTime(LocalDateTime.ofInstant(cd.toInstant(), ZoneId.systemDefault()));
            }
            result.setCreateOpr(rs.getInt("create_opr"));

            Date ud = rs.getTimestamp("update_time");
            if(ud != null) {
                result.setUpdateTime(LocalDateTime.ofInstant(ud.toInstant(), ZoneId.systemDefault()));
            }
            result.setUpdateOpr(rs.getInt("update_opr"));

            result.setEnableFlag(rs.getBoolean("enable_flag"));
            result.setDeleteFlag(rs.getBoolean("delete_flag"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
