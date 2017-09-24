package com.lian.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lian.entity.Category;
import com.lian.entity.Good;
import com.lian.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("goodsAction")
@Scope("prototype")
public class GoodsAction extends ActionSupport {
	@Resource(name="goodsService")
	private GoodsService goodsService;
	private HttpServletRequest request;
	private String categoryId;
	private String keyword;
	private String minPrice;
	private String maxPrice;
	private String categoryName;
	private String goodsName;
	private String description;
	private String price;
	private File imgUrl;
	private String imgUrlContentType;
	private String imgUrlFileName;
	
	

	public GoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public File getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(File imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getImgUrlContentType() {
		return imgUrlContentType;
	}
	public void setImgUrlContentType(String imgUrlContentType) {
		this.imgUrlContentType = imgUrlContentType;
	}
	public String getImgUrlFileName() {
		return imgUrlFileName;
	}
	public void setImgUrlFileName(String imgUrlFileName) {
		this.imgUrlFileName = imgUrlFileName;
	}
	
	public String get() throws Exception {
		request = ServletActionContext.getRequest();
		if (keyword != null && !keyword.equals("")) {
			keyword = keyword.trim();
		} else {
			keyword = null;
		}
		Integer categoryIdInt = null;
		if (categoryId != null && !categoryId.equals("")) {
			categoryIdInt = Integer.valueOf(categoryId);
		}
		Float minPriceFloat = null;
		if (minPrice != null && !minPrice.equals("")) {
			minPriceFloat = Float.valueOf(minPrice);
		}
		Float maxPriceFloat = null;
		if (maxPrice != null && !maxPrice.equals("")) {
			maxPriceFloat = Float.valueOf(maxPrice);
		}
		List<Good> goods = goodsService.getByMultiRequirement(keyword, categoryIdInt, minPriceFloat, maxPriceFloat);
		request.setAttribute("goods", goods);
		return "success";
	}
	
	public String add() throws Exception {
		request = ServletActionContext.getRequest();
		String relationPath = "img/";
		String root = ServletActionContext.getServletContext().getRealPath(relationPath);
		String finalPath = relationPath + imgUrlFileName;
		FileInputStream is = null;
		FileOutputStream os = null;
        try {
        	is = new FileInputStream(imgUrl);
			os = new FileOutputStream(new File(root, imgUrlFileName));        
	        byte[] buffer = new byte[1024];
	        int length = 0;
	        while ((length = is.read(buffer)) != -1) {
	        	os.write(buffer, 0, length);
	        }
	        os.flush();	        
	        Good good = new Good();
			good.setGoodsName(goodsName);
			good.setDescription(description);
			good.setPrice(Float.valueOf(price));
			good.setImgUrl(finalPath);
			Category c = new Category();
			c.setId(Integer.valueOf(categoryId));
			good.setCategory(c);
	        goodsService.save(good);
	        List<Category> categories = goodsService.getAllCategory();
			request.setAttribute("categories", categories);
	        request.setAttribute("message", "添加成功");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
			return "failure";
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public String getAllCategories() throws Exception {
		request = ServletActionContext.getRequest();
		List<Category> categories = goodsService.getAllCategory();
		request.setAttribute("categories", categories);
		return "success";
	}
	
	public String addCategory() throws Exception {
		request = ServletActionContext.getRequest();
		if (categoryName != null && !categoryName.equals("")) {
			try {
				Category c = new Category();
				c.setCategoryName(categoryName);
				goodsService.saveCategory(c);
				request.setAttribute("message", "添加成功");
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "添加失败");
				return "failure";
			}			
		} else {
			request.setAttribute("message", "添加失败");
			return "failure";
		}
	}
	
}
