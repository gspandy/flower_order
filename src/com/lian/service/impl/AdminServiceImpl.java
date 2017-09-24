package com.lian.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lian.dao.AdminDao;
import com.lian.entity.Admin;
import com.lian.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource(name="adminDao")
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	@Override
	@Transactional(readOnly=true)
	public Admin checkAdmin(String username, String password) {
		return adminDao.getByUsernameAndPassword(username, password);
	}

}
