package com.itheima.service;

import com.itheima.domain.ContactInfo;

import java.util.List;
import java.util.Map;

// 通讯录相关业务
public interface ContactInfoService {
    /**
     * 查询所有通讯录对象
     * @return 通讯录对象集合
     */
//    public List<ContactInfo> queryAll();

    /**
     * 删除指定通讯录
     * @param id 被删除的通讯录的标识
     * @return 是否删除成功
     */
//    public boolean delContact(String id);

    /**
     * 添加用户
     * @param parameterMap 参数
     * @return 添加是否成功
     */
//    public boolean addContact(Map<String, String[]> parameterMap);

    /**
     * 分页查询通讯录
     * @param pageOffset Limit第1个关键字
     * @param pageSize   limit第2个关键字
     * @return 分页查询的结果
     */
//    public List<ContactInfo> queryPage(int pageOffset, int pageSize);
    //currentPage 当前页面

    /**
     * 统计通讯录有多少条
     * @return 通讯录的条数
     */
    public int queryRecordCount();

    /**
     * 查询某一个通讯录
     * @param id 查询的唯一标识
     * @return 查询得到的结果，如果查询成功的话，得到通讯录实体；如果查询失败的话，得到null
     */
    public ContactInfo queryContactById(String id);

    /**
     * 修改通讯录的记录
     * @param parameterMap 修改的内容
     * @return 修改是否成功
     */
    public boolean modifyContact(Map<String, String[]> parameterMap);

    public List<ContactInfo> queryAll();

    public boolean delContact(String id);

    public boolean addContact(Map<String, String[]> parameterMap);


    public List<ContactInfo> queryPage(int pageOff, int pageSize);

}
