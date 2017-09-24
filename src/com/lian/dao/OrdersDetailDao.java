package com.lian.dao;

import java.util.List;

import com.lian.dao.common.BaseDao;
import com.lian.entity.Order;
import com.lian.entity.OrdersDetail;

public interface OrdersDetailDao extends BaseDao<OrdersDetail> {
	public List<OrdersDetail> getByOrder(Order order);
}
