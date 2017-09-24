package com.lian.dao;

import java.util.List;

import com.lian.dao.common.BaseDao;
import com.lian.entity.Category;
import com.lian.entity.Good;

public interface GoodsDao extends BaseDao<Good> {
	public List<Good> getByPriceRange(float minPrice, float maxPrice);
	public List<Good> getByMultiRequirement(String keyword, Integer categoryId, Float minPrice, Float maxPrice);
}
