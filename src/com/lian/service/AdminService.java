package com.lian.service;

import com.lian.entity.Admin;
import com.lian.entity.User;

public interface AdminService {
	public Admin checkAdmin(String username, String password);
}
