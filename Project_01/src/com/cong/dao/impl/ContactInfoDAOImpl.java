package com.itheima.dao.impl;

import com.itheima.dao.ContactInfoDAO;
import com.itheima.domain.ContactInfo;
import com.itheima.utils.DBUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ContactInfoDAOImpl implements ContactInfoDAO {
    private JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate();

    @Override
    public List<ContactInfo> queryAll() {
        String sql = "SELECT * FROM contact_info WHERE del=0";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class));
    }

    @Override
    public int delContact(String id) {
        String sql = "UPDATE contact_info SET del=1 WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int addContact(ContactInfo contact) {
        String sql = "INSERT INTO contact_info(`name`, `gender`, `birthday`, `birthplace`, `mobile`, `email`) VALUES(?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail());
    }

    @Override
    public List<ContactInfo> queryPage(int pageOffset, int pageSize) {
        String sql = "SELECT * FROM contact_info WHERE del=0 LIMIT ?, ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class), pageOffset, pageSize);
    }

    @Override
    public int queryRecordCount() {
        String sql = "SELECT COUNT(*) FROM contact_info WHERE del=0";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
