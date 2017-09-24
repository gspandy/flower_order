package com.lian.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.lian.dao.GoodsDao;
import com.lian.dao.common.impl.BaseDaoImpl;
import com.lian.entity.Category;
import com.lian.entity.Good;
import com.lian.util.PageModel;

@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Good> implements GoodsDao {

	@Override
	public List<Good> getByPriceRange(float minPrice, float maxPrice) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Good g where g.price between :minPrice and :maxPrice";
		Query query = session.createQuery(hql);
		query.setFloat("minPrice", minPrice);
		query.setFloat("maxPrice", maxPrice);
		List<Good> goods = (List<Good>) query.list();
		return goods;
	}

	@Override
	public List<Good> getByMultiRequirement(String keyword, Integer categoryId, Float minPrice, Float maxPrice) {
		Session session = sessionFactory.getCurrentSession();
		StringBuilder sb = new StringBuilder("from Good g");
		boolean hadAppendWhere = false;
		if(keyword != null && !keyword.equals("")) {
			if (!hadAppendWhere) {
				sb.append(" where");
				hadAppendWhere = true;
			} else {
				sb.append(" and");
			}
			sb.append(" g.goodsName like '%"+keyword+"%'");
		}
		if (categoryId != null) {
			if (!hadAppendWhere) {
				sb.append(" where");
				hadAppendWhere = true;
			} else {
				sb.append(" and");
			}
			sb.append(" g.category.id = " + categoryId.toString());
		}
		if (minPrice != null && maxPrice != null) {
			if (minPrice.floatValue() > maxPrice.floatValue()) {
				Float temp = minPrice;
				minPrice = maxPrice;
				maxPrice = temp;
			}
		}
		if (minPrice != null) {
			if (!hadAppendWhere) {
				sb.append(" where");
				hadAppendWhere = true;
			} else {
				sb.append(" and");
			}
			sb.append(" g.price >= " + minPrice.toString());
		}
		if (maxPrice != null) {
			if (!hadAppendWhere) {
				sb.append(" where");
				hadAppendWhere = true;
			} else {
				sb.append(" and");
			}
			sb.append(" g.price <= " + maxPrice.toString());
		}
		Query query = session.createQuery(sb.toString());	
		List<Good> goods = (List<Good>) query.list();
		return goods;
	}
	
}
