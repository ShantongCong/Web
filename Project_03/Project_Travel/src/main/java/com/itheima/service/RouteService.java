package com.itheima.service;

import com.itheima.domain.RoutePageBean;

import java.util.Map;

public interface RouteService {
    public Map<String, Object> queryDistillation();

    public void queryPage(String cid, RoutePageBean routePageBean);
}
