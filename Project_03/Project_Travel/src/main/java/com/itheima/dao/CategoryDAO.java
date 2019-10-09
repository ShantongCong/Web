package com.itheima.dao;

import com.itheima.domain.Category;

import java.util.List;

public interface CategoryDAO {
    public List<Category> queryAll();

    public int append(List<Category> result);
}
