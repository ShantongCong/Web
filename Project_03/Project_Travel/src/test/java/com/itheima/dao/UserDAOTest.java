package com.itheima.dao;

import com.itheima.dao.imp.UserDAOImp;
import com.itheima.domain.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void queryByEmail() {

        UserDAOImp daoImp = new UserDAOImp();
        List<User> users = daoImp.queryByEmail("123@qq.com");
        System.out.println(users.size());
    }
}