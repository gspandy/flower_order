package com.lian.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lian.dao.UserDao;
import com.lian.dao.common.impl.BaseDaoImpl;
import com.lian.entity.User;
import com.lian.util.PageModel;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getByUsernameAndPassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User t where t.userName = :username and t.password = :password";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		query.setString("password", password);
		return (User) query.uniqueResult();
	}

	@Override
	public User getByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User t where t.userName = :username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		return (User) query.uniqueResult();
	}
	
	

}
