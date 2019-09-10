package com.cong.dao.iml;

import com.cong.dao.ContactInfoDAO;
import com.cong.domain.ContactInfo;
import com.cong.utils.DBUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * <h3>day01-Tomcat & Servlet</h3>
 * <p>待备注</p>
 *
 * @author : cong
 * @date : 2019-09-10 21:53
 **/
public class ContactInfoDAOImpl implements ContactInfoDAO {
    // 获取jdbcTemplate
    private JdbcTemplate jdbcTemplate = DBUtils.getJdbcTemplate();

    @Override
    public List<ContactInfo> queryAll() {
        // 创建SQL语句
        String sql = "SELECT * FROM contact_info WHERE del=0";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class));
    }

}
