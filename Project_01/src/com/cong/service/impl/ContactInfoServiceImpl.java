package com.itheima.service.impl;

import com.itheima.dao.ContactInfoDAO;
import com.itheima.dao.impl.ContactInfoDAOImpl;
import com.itheima.domain.ContactInfo;
import com.itheima.service.ContactInfoService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class ContactInfoServiceImpl implements ContactInfoService {
    private ContactInfoDAO dao = new ContactInfoDAOImpl();

    @Override
    public List<ContactInfo> queryAll() {
//        List<ContactInfo> contacts = dao.queryAll();
//        return contacts;
        return dao.queryAll();
    }

    @Override
    public boolean delContact(String id) {
        int delResult = dao.delContact(id);

//        if (delResult == 1) {
//            return true;
//        } else {
//            return false;
//        }
        return delResult == 1;
    }

    @Override
    public boolean addContact(Map<String, String[]> parameterMap) {
        ContactInfo contact = new ContactInfo();
        try {
            BeanUtils.populate(contact, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int addResult = dao.addContact(contact);
        return addResult == 1;
    }

    @Override
    public List<ContactInfo> queryPage(int pageOffset, int pageSize) {
        return dao.queryPage(pageOffset, pageSize);
    }

    @Override
    public int queryRecordCount() {
        return dao.queryRecordCount();
    }
}
