package com.lian.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lian.dao.CategoryDao;
import com.lian.dao.common.impl.BaseDaoImpl;
import com.lian.entity.Category;
import com.lian.util.PageModel;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

}
