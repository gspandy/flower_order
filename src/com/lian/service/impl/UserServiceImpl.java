package com.lian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lian.dao.UserDao;
import com.lian.entity.User;
import com.lian.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public User checkUser(String username, String password) {
		return userDao.getByUsernameAndPassword(username, password);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	@Transactional
	public void edit(User user) {
		userDao.edit(user);
	}

	@Override
	@Transactional
	public void delete(User user) {
		userDao.delete(user.getId());
	}
	
	
}
