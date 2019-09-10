package com.cong.service;

import com.cong.domain.ContactInfo;

import java.util.List;

public interface ContactInfoService {
    // 查询所有用户
    public List<ContactInfo> queryAll();
}
