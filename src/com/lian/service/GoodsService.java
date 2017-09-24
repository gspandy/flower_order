package com.lian.service;

import java.util.List;

import com.lian.entity.Category;
import com.lian.entity.Good;

public interface GoodsService {
	public Good getById(Integer id);
	public List<Good> getAll();
	public List<Good> getByCategoryId(Integer id);
	public List<Good> getByPriceRange(float minPrice, float maxPrice);	
	public List<Good> getByMultiRequirement(String keyword, Integer categoryId, Float minPrice, Float maxPrice);
	public List<Category> getAllCategory();
	public void save(Good good);
	public void edit(Good good);
	public void delete(Good good);
	public void saveCategory(Category category);
	public void editCategory(Category category);
	public void deleteCategory(Category category);
}
