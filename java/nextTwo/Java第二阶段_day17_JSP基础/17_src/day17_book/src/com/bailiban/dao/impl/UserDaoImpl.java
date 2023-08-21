package com.bailiban.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bailiban.dao.UserDao;
import com.bailiban.domain.User;
import com.bailiban.utils.JDBCUtils;

/**
 * 操作数据库中User表的类
 */
public class UserDaoImpl implements UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据,没有查询到，返回null
     */
    @Override
	public User login(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from t_user where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());


            return user;
        } catch (DataAccessException e) {
        	//打印调试信息
            e.printStackTrace();
            return null;
        }
    }
}
