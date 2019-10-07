package com.itheima.dao.imp;

import com.itheima.dao.UserDAO;
import com.itheima.domain.User;
import com.itheima.utils.C3P0Util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.util.List;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-07 20:04
 **/
public class UserDAOImp implements UserDAO {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());

    @Override
    public List<User> queryByEmail(String email) {
        String sql = "SELECT * FROM tab_user WHERE email= ?";

        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email);
        return userList;
    }

    @Override
    public int insert(User user) {


        String sql = "INSERT INTO tab_user('username','password','realname','birthday','gender','mobile','email','code') VALUES (?,?,?,?,?,?,?,?)";
        String sql1 = "INSERT INTO tab_user(`username`, `password`, `realname`, `birthday`, `gender`, `mobile`, `email`,  `code`) VALUES (?,?,?,?,?,?,?,?)";


         return jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getRealname(),
                user.getBirthday(),
                user.getGender(),
                user.getMobile(),
                user.getEmail(),
                user.getCode());

    }
}
