package com.itheima.dao;

import com.itheima.domain.Route;

import java.util.List;

public interface RouteDAO {
    public List<Route> populate();

    public List<Route> newest();

    public List<Route> theme();

    public List<Route> queryPage(String cid, int pageOffset, int pageSize);

    /**
     * 获取信息的总条数
     *
     * @return
     */
    public int queryRecordCount(String cid);

}
