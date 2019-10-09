package com.itheima.dao.imp;

import com.itheima.dao.CategoryDAO;
import com.itheima.domain.Category;
import com.itheima.utils.C3P0Util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-08 22:54
 **/
public class CategoryDAOImp implements CategoryDAO {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(C3P0Util.getDataSource());
    @Override
    public List<Category> queryAll() {
        String sql="SELECT * FROM tab_category";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public int append(List<Category> result) {
        //TODO 从数据库中添加数据
        return 0;
    }
}
