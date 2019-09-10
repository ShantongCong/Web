package com.cong.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * <h3>day01-Tomcat & Servlet</h3>
 * <p>数据源工具类</p>
 *
 * @author : cong
 * @date : 2019-09-10 20:13
 **/
public class DBUtils {

    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return ds;
    }
    public static JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(ds);
    }

}
