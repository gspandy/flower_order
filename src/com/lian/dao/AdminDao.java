package com.lian.dao;

import com.lian.dao.common.BaseDao;
import com.lian.entity.Admin;
import com.lian.entity.User;

public interface AdminDao extends BaseDao<Admin> {
	public Admin getByUsernameAndPassword(String username, String password);
}
