package com.lian.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lian.dao.OrderDao;
import com.lian.dao.common.impl.BaseDaoImpl;
import com.lian.entity.Order;
import com.lian.util.PageModel;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	
	public int saveWithReturn(Order entity) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(entity);
	}
	
	
}
