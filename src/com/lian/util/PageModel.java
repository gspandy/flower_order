package com.lian.util;

import java.util.List;

public class PageModel<T> {
	//当前页号
	private int pageNo = 1;
	//每页显示的记录数
	private int pageSize = 10;
	//总记录数
	private int recordCount;
	//总页数
	private int pageCount;
	//存放分页数据的集合
	private List<T> datas;
	// 是否有首页（当前页号是否为首页）
	private boolean hasFirst;
	// 是否有上一页
	private boolean hasPrevious;
	// 是否有下一页
	private boolean hasNext;
	// 是否有尾页
	private boolean hasLast;
	
	public PageModel(){
		
	}
	
	public PageModel(int pageNo,int pageSize){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		if (this.getRecordCount() <= 0){
			return 0;
		} else {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	public boolean isHasFirst() {
		if (pageNo == 1) {
			return false;
		}
		return true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasPrevious() {
		if(isHasFirst())
			return true;
		else
			return false;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean isHasNext() {
		if(isHasLast())
			return true;
		else
			return false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasLast() {
		if(pageNo == getPageCount())
			return false;
		else
			return true;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}
