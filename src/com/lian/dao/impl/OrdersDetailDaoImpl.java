package com.lian.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lian.dao.OrdersDetailDao;
import com.lian.dao.common.impl.BaseDaoImpl;
import com.lian.entity.Good;
import com.lian.entity.Order;
import com.lian.entity.OrdersDetail;
import com.lian.util.PageModel;

@Repository("ordersDetailDao")
public class OrdersDetailDaoImpl extends BaseDaoImpl<OrdersDetail> implements OrdersDetailDao {

	@Override
	public List<OrdersDetail> getByOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from OrdersDetail o where o.order.ordersId = :ordersId";
		Query query = session.createQuery(hql);
		query.setInteger("ordersId", order.getOrdersId());
		List<OrdersDetail> ordersDetails = (List<OrdersDetail>) query.list();
		return ordersDetails;
	}
	
}
