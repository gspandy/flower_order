package com.lian.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.lian.entity.OrdersDetail;

public class Cart {
	private Map<Integer, OrdersDetail> items;
	
	public Map<Integer, OrdersDetail> getItems() {
		return items;
	}
	public void setItems(Map<Integer, OrdersDetail> items) {
		this.items = items;
	}
	
	public Cart() {
		if (items == null) {
			items = new HashMap<Integer,OrdersDetail>();
		}			
	}
	
	public void addGoods(int goodsId, OrdersDetail ordersDetail) {
		if (items.containsKey(goodsId)) {
			OrdersDetail _ordersDetail = items.get(goodsId);
			ordersDetail.setNum(_ordersDetail.getNum() + ordersDetail.getNum());
			items.put(goodsId, ordersDetail);
		} else {
			items.put(goodsId, ordersDetail);
		}
	}
	
	public void updateCart(int goodsId, int num) {
		OrdersDetail ordersDetail = items.get(goodsId);
		ordersDetail.setNum(num);
		items.put(goodsId, ordersDetail);
	}
	
	public int getTotalNum() {
		int totalNum=0;
		for(Iterator it = items.values().iterator(); it.hasNext(); ) {
			OrdersDetail orderitem = (OrdersDetail) it.next();
			totalNum += orderitem.getNum();
		}
		return totalNum;
	}
	
	public int getTotalPrice() {
		int totalPrice=0;
		for(Iterator it = items.values().iterator(); it.hasNext(); ) {
			OrdersDetail orderitem = (OrdersDetail) it.next();
			totalPrice += orderitem.getPrice() * orderitem.getNum();
		}
		return totalPrice;
	}
}
