package com.lian.dao;

import com.lian.dao.common.BaseDao;
import com.lian.entity.Order;

public interface OrderDao extends BaseDao<Order> {
	public int saveWithReturn(Order entity);
}
