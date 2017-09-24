package com.lian.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lian.dao.CategoryDao;
import com.lian.dao.GoodsDao;
import com.lian.entity.Category;
import com.lian.entity.Good;
import com.lian.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Resource(name="goodsDao")
	private GoodsDao goodsDao;
	@Resource(name="categoryDao")
	private CategoryDao categoryDao;
		
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Good> getByCategoryId(Integer id) {
		Category category = categoryDao.get(id);
		List<Good> goods = new ArrayList<>();
		goods.addAll(category.getGoods());
		return goods;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Good> getByPriceRange(float minPrice, float maxPrice) {
		return goodsDao.getByPriceRange(minPrice, maxPrice);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Category> getAllCategory() {
		return categoryDao.getAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Good> getByMultiRequirement(String keyword, Integer categoryId, Float minPrice, Float maxPrice) {
		return goodsDao.getByMultiRequirement(keyword, categoryId, minPrice, maxPrice);
	}

	@Override
	@Transactional(readOnly=true)
	public Good getById(Integer id) {
		return goodsDao.get(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Good> getAll() {
		return goodsDao.getAll();
	}

	@Override
	@Transactional
	public void save(Good good) {
		goodsDao.save(good);
	}

	@Override
	@Transactional
	public void edit(Good good) {
		goodsDao.edit(good);
	}

	@Override
	@Transactional
	public void delete(Good good) {
		goodsDao.delete(good.getId());
	}

	@Override
	@Transactional
	public void saveCategory(Category category) {
		categoryDao.save(category);		
	}

	@Override
	@Transactional
	public void editCategory(Category category) {
		categoryDao.edit(category);
	}

	@Override
	@Transactional
	public void deleteCategory(Category category) {
		categoryDao.delete(category.getId());
	}

}
