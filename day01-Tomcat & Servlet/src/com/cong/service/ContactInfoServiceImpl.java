package com.cong.service;

import com.cong.dao.ContactInfoDAO;
import com.cong.dao.iml.ContactInfoDAOImpl;
import com.cong.domain.ContactInfo;

import java.util.List;

/**
 * <h3>day01-Tomcat & Servlet</h3>
 * <p>带备注</p>
 *
 * @author : cong
 * @date : 2019-09-10 21:56
 **/
public class ContactInfoServiceImpl implements ContactInfoService {
    // 定义DAO成员变量
    // Service调用DAO获取数据，提供给Servlet使用
    private ContactInfoDAO dao = new ContactInfoDAOImpl();

    @Override
    public List<ContactInfo> queryAll() {
        return dao.queryAll();
    }
}
