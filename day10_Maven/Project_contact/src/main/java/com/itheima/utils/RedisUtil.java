package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * <h3>Project_02</h3>
 * <p>Redis工具类</p>
 *
 * @author : cong
 * @date : 2019-09-23 22:05
 **/
public class RedisUtil {
    private static JedisPool pool=null;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("redis");

        String host = bundle.getString("host");
        String port = bundle.getString("port");
        String maxTotal = bundle.getString("maxTotal");
        String maxWaitMills = bundle.getString("maxWaitMills");

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(Integer.parseInt(maxWaitMills));
        config.setMaxTotal(Integer.parseInt(maxTotal));

        pool=new JedisPool(config,host,Integer.parseInt(port));
    }

    public static Jedis getResource(){
        return pool.getResource();
    }

}
