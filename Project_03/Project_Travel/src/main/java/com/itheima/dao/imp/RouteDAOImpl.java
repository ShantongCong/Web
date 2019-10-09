package com.itheima.dao.imp;

import com.itheima.dao.RouteDAO;
import com.itheima.domain.Route;
import com.itheima.utils.C3P0Util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-09 13:02
 **/
public class RouteDAOImpl implements RouteDAO {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());

    @Override
    public List<Route> populate() {
        String sql = "SELECT *FROM tab_route WHERE rflag=1 ORDER BY  count DESC LIMIT 0,4;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
        //SELECT *FROM tab_route WHERE rflag=1 ORDER BY  count DESC LIMIT 0,4;
    }

    @Override
    public List<Route> newest() {
        String sql = "SELECT *FROM tab_route WHERE rflag=1 ORDER BY  rdate DESC LIMIT 0,4;";
        //SELECT *FROM tab_route WHERE rflag=1 ORDER BY  rdate DESC LIMIT 0,4;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
    }

    @Override
    public List<Route> theme() {
        //SELECT *FROM tab_route WHERE rflag=1 and isThemeTour=1 ORDER BY  rdate DESC;
        String sql = "SELECT *FROM tab_route WHERE rflag=1 and isThemeTour=1 ORDER BY  rdate DESC;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
    }

    @Override
    public List<Route> queryPage(String cid,int pageOffset, int pageSize) {
        String sql = "SELECT *FROM tab_route WHERE rflag=1 AND cid=? ORDER BY  rdate DESC limit ?,?;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class),cid,pageOffset,pageSize);
    }

    @Override
    public int queryRecordCount(String cid) {
        String sql = "SELECT count(*) FROM tab_route WHERE rflag=1 AND cid=?  ";
        return jdbcTemplate.queryForObject(sql,Integer.class,cid);
    }
}
