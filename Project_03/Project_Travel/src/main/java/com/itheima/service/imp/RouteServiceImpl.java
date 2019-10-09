package com.itheima.service.imp;

import com.itheima.dao.RouteDAO;
import com.itheima.dao.imp.RouteDAOImpl;
import com.itheima.domain.Route;
import com.itheima.domain.RoutePageBean;
import com.itheima.service.RouteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-09 11:59
 **/
public class RouteServiceImpl implements RouteService {
    private RouteDAO dao = new RouteDAOImpl();

    @Override
    public Map<String, Object> queryDistillation() {
        Map<String, Object> result = new HashMap<>();
        List<Route> populate = dao.populate();
        List<Route> newest = dao.newest();
        List<Route> theme = dao.theme();
        result.put("populate", populate);
        result.put("newest", newest);
        result.put("theme", theme);
        return result;


    }


    @Override
    public void queryPage(String cid,RoutePageBean routePageBean) {
        int currentPage = routePageBean.getCurrentPage();
        int pageSize = routePageBean.getPageSize();
        int pageOffset = (currentPage - 1) * pageSize;
        routePageBean.setPageOffset(pageOffset);

        //获取线路实体数据
        List<Route> routes = dao.queryPage(cid,pageOffset, pageSize);

        //获取一共多少条数据
        int recordCount = dao.queryRecordCount(cid);

        //获取一共多少页
        int pageCount = (int) Math.ceil(recordCount / (double) routePageBean.getPageSize());

        routePageBean.setRecordCount(recordCount);
        routePageBean.setPageCount(pageCount);

        //检测后端数据后端用
//        System.out.println("recordCount = " + recordCount);
//        System.out.println("pageCount = " + pageCount);

        routePageBean.setRoutes(routes);
    }
}
