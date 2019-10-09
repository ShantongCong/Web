package com.itheima.dao.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.CategoryDAO;
import com.itheima.domain.Category;
import com.itheima.utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-09 10:00
 **/
public class CategoryRedisDAOImp implements CategoryDAO {
       private Jedis jedis = JedisUtil.getJedis();

    @Override
    public List<Category> queryAll() {
        List<String> categories = jedis.lrange("heima.travel.categories", 0, -1);
        List<Category> result=new ArrayList<>();

        ObjectMapper mapper=new ObjectMapper();

        for (String category : categories) {
            Category readValue = null;
            try {
                readValue = mapper.readValue(category, Category.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.add(readValue);

        }

        return result;
    }

    //把数据库中的数据添加到缓存中
    @Override
    public int append(List<Category> result) {
        ObjectMapper mapper = new ObjectMapper();
        for (Category category : result) {
            try {
                String valueAsString = mapper.writeValueAsString(category);
                jedis.rpush("heima.travel.categories",valueAsString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return result.size();
    }
}
