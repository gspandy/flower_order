package com.lian.service;

import java.util.List;

import com.lian.entity.Order;
import com.lian.entity.OrdersDetail;

public interface OrderService {
	public void saveOrder(Order order);
	public List<Order> getAll();
	public List<Order> getByUserId(Integer id);
	public Order getById(Integer id);
	public List<OrdersDetail> getOrderDetailByOrderId(Integer id);
}
