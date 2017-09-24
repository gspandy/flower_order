package com.lian.dao;

import com.lian.dao.common.BaseDao;
import com.lian.entity.User;

public interface UserDao extends BaseDao<User> {
	public User getByUsernameAndPassword(String username, String password);
	public User getByUsername(String username);
}
