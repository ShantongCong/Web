package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDAO {
    public List<User> queryByEmail(String email);

    /**
     * 向数据库中插入数据
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     *
     * @param code
     * @return 受影响的行数
     */
    public int activeCode(String code);

}
