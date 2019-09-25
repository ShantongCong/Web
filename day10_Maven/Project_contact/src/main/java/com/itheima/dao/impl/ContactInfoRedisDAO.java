package com.itheima.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.ContactInfoDAO;
import com.itheima.domain.ContactInfo;
import com.itheima.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Project_02</h3>
 * <p>Redis实现类</p>
 *
 * @author : cong
 * @date : 2019-09-23 18:52
 **/
public class ContactInfoRedisDAO implements ContactInfoDAO {
    @Override
    public int queryRecordCount() {
        return 0;
    }

    @Override
    public List<ContactInfo> queryContactById(String id) {
        return null;
    }

    @Override
    public int modifyContact(ContactInfo contact) {
        return 0;
    }

    @Override
    public List<ContactInfo> queryAll() {

        Jedis jedis = RedisUtil.getResource();
        List<String> contacts = jedis.lrange("contact", 0, -1);
        //把字符串类型的List转化为ContactImp对象的List;

        ArrayList<ContactInfo> result = new ArrayList<>();

        for (String contactItem : contacts) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                //把字符串转化为ContactInfo对象
                ContactInfo contactInfo = mapper.readValue(contactItem, ContactInfo.class);
                result.add(contactInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        jedis.close();
        return result;
    }

    @Override
    public int delContact(String id) {
        return 0;
    }

    @Override
    public int addContact(ContactInfo contactInfo) {

        Jedis jedis = RedisUtil.getResource();

        ObjectMapper mapper = new ObjectMapper();
        try {
            jedis.rpush("contact",mapper.writeValueAsString(contactInfo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        jedis.close();
        return 1;
    }

    @Override
    public List<ContactInfo> queryPage(int pageOff, int pageSize) {
        return null;
    }
}
