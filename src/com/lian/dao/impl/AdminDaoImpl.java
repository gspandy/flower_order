package com.lian.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lian.dao.AdminDao;
import com.lian.dao.common.impl.BaseDaoImpl;
import com.lian.entity.Admin;
import com.lian.entity.User;
import com.lian.util.PageModel;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

	@Override
	public Admin getByUsernameAndPassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Admin t where t.username = :username and t.password = :password";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		query.setString("password", password);
		return (Admin) query.uniqueResult();
	}
	
}
