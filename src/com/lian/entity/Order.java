package com.lian.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private int ordersId;
	private User user;
	private int num;
	private float sum;
	private Date createTime;
	private Set<OrdersDetail> ordersDetails = new HashSet<OrdersDetail>();
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Set<OrdersDetail> getOrdersDetails() {
		return ordersDetails;
	}
	public void setOrdersDetails(Set<OrdersDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}
	
	
	
}
