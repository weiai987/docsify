package com.bailiban.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bailiban.dao.UserDao;
import com.bailiban.domain.User;
import com.bailiban.utils.JDBCUtils;

/**
 * �������ݿ���User�����
 */
public class UserDaoImpl implements UserDao {

    //����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * ��¼����
     * @param loginUser ֻ���û���������
     * @return user�����û�ȫ������,û�в�ѯ��������null
     */
    @Override
	public User login(User loginUser){
        try {
            //1.��дsql
            String sql = "select * from t_user where username = ? and password = ?";
            //2.����query����
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());


            return user;
        } catch (DataAccessException e) {
        	//��ӡ������Ϣ
            e.printStackTrace();
            return null;
        }
    }
}
