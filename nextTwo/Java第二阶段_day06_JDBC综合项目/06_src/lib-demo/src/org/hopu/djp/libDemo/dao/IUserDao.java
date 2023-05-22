package org.hopu.djp.libDemo.dao;

import org.hopu.djp.libDemo.entity.User;

import java.sql.ResultSet;
import java.util.List;

public interface IUserDao {
    //    新增用户
    int addOne(User user, int oprId);
    //    查看所有用户
    List<User> findAll();
    //    查看指定用户
    User findById(int userId);
    //    根据用户信息查找用户
    List<User> findList(User user);
    //    修改指定用户
    int editOne(User user, int oprId);
    //    删除指定用户
    int delOneById(int userId, int oprId);
    //    禁用/启用指定用户
    int enableById(int userId, Boolean b, int oprId);
    //    从结果集转换成实体类
    User toUser(ResultSet rs);
}
