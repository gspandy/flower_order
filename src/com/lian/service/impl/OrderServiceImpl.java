package com.lian.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lian.dao.OrderDao;
import com.lian.dao.OrdersDetailDao;
import com.lian.dao.UserDao;
import com.lian.entity.Order;
import com.lian.entity.OrdersDetail;
import com.lian.entity.User;
import com.lian.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Resource(name="orderDao")
	private OrderDao orderDao;
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="ordersDetailDao")
	private OrdersDetailDao ordersDetailDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	@Transactional
	public void saveOrder(Order order) {
		User userFromDb = userDao.getByUsername(order.getUser().getUserName());
		order.getUser().setId(userFromDb.getId());
		Set<OrdersDetail> ordersDetails = order.getOrdersDetails();
		order.setOrdersDetails(null);
		int id = orderDao.saveWithReturn(order);
		order.setOrdersId(id);
		Iterator<OrdersDetail> it = ordersDetails.iterator();
		while(it.hasNext()) {
			OrdersDetail ordersDetail = it.next();
			ordersDetail.setOrder(order);
			ordersDetailDao.save(ordersDetail);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Order> getAll() {	
		return orderDao.getAll();
	}

	@Override
	public List<Order> getByUserId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrdersDetail> getOrderDetailByOrderId(Integer id) {
		Order order = orderDao.get(id);
		List<OrdersDetail> ordersDetails = new ArrayList<>();
		ordersDetails.addAll(order.getOrdersDetails());
		return ordersDetails;
	}

}
