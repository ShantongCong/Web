package com.itheima.service.imp;

import com.itheima.dao.CategoryDAO;
import com.itheima.dao.imp.CategoryDAOImp;
import com.itheima.dao.imp.CategoryRedisDAOImp;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;

import java.util.List;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-08 22:52
 **/
public class CategoryServiceImp implements CategoryService {
    private CategoryDAO dbDAO = new CategoryDAOImp();
    private CategoryDAO redisDAO=new CategoryRedisDAOImp();

    @Override
    public List<Category> queryAll() {
        List<Category> result = redisDAO.queryAll();

        if (result.size()==0){
            //缓存内为空 从数据库中读入
            System.out.println("缓存内为空 从数据库中读入");
            result=dbDAO.queryAll();
            redisDAO.append(result);
        }
        return  result;
    }
}
