package com.lian.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private int id;
	private String categoryName;
	private Set<Good> goods = new HashSet<Good>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	
	
}
