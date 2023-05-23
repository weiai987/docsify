package com.blb.bookms.dao;

import com.blb.bookms.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDAO {

    User login(@Param("username") String username, @Param("password")String password);
}
