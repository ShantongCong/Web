package com.itheima.dao.impl;

import com.itheima.dao.ContactInfoDAO;
import com.itheima.domain.ContactInfo;
import com.itheima.utils.DBUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ContactInfoDAOImpl implements ContactInfoDAO {
    private JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate();

//    @Override
//    public List<ContactInfo> queryAll() {
//        String sql = "SELECT * FROM contact_info WHERE del=0";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class));
//    }

    @Override
    public int delContact(String id) {
        String sql = "UPDATE contact_info SET del=1 WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int addContact(ContactInfo contactInfo) {
        String sql = "INSERT INTO contact_info (name, gender, birthday, birthplace, mobile, email) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                contactInfo.getName(),
                contactInfo.getGender(),
                contactInfo.getBirthday(),
                contactInfo.getBirthplace(),
                contactInfo.getMobile(),
                contactInfo.getEmail());

    }

    @Override
    public List<ContactInfo> queryPage(int pageOff, int pageSize) {

        String sql="SELECT *FROM contact_info WHERE del=0 limit ?,?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class), pageOff, pageSize);

    }

//    @Override
//    public int addContact(ContactInfo contact) {
//        String sql = "INSERT INTO contact_info(`name`, `gender`, `birthday`, `birthplace`, `mobile`, `email`) VALUES(?, ?, ?, ?, ?, ?)";
//        return jdbcTemplate.update(sql,
//                contact.getName(),
//                contact.getGender(),
//                contact.getBirthday(),
//                contact.getBirthplace(),
//                contact.getMobile(),
//                contact.getEmail());
//    }

//    @Override
//    public List<ContactInfo> queryPage(int pageOffset, int pageSize) {
//        String sql = "SELECT * FROM contact_info WHERE del=0 LIMIT ?, ?";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class), pageOffset, pageSize);
//    }

    @Override
    public int queryRecordCount() {
        String sql = "SELECT COUNT(*) FROM contact_info WHERE del=0";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<ContactInfo> queryContactById(String id) {
        String sql = "SELECT * FROM contact_info WHERE del=0 AND id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class), id);
    }

    @Override
    public int modifyContact(ContactInfo contact) {
        String sql = "UPDATE contact_info SET name=?, gender=?, birthday=?, birthplace=?, mobile=?, email=? WHERE del=0 AND id=?";
        return jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail(),
                contact.getId());
    }

    @Override
    public List<ContactInfo> queryAll() {
        String sql = "SELECT *FROM contact_info WHERE del=0";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactInfo.class));
    }

//    @Override
//    public int delContact(String id) {
//        String sql="UPDATE contact_info SET del=1 WHERE  id=?";
//        int update = jdbcTemplate.update(sql, id);
//        return update;
//    }

}
