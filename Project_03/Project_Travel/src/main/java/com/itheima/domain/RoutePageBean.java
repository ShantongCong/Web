package com.itheima.domain;

import java.util.List;

/**
 * <h3>Project_Travel</h3>
 * <p>路线翻页JAVABEAN</p>
 *
 * @author : cong
 * @date : 2019-10-09 19:03
 **/
public class RoutePageBean {
    //旅游实体线路图
    private List<Route> routes;
    //一共有多少页
    private int pageCount;
    //一共多少条数据
    private int recordCount;
    //当前式第几页
    private int currentPage;
    //查询时LIMIT 的第1个参数
    private int pageOffset;
    //1.一共有多少条数据
    //2.LIMIT的第二个参数
    private int pageSize;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
