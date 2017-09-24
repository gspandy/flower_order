package com.lian.service;

import java.util.List;

import com.lian.entity.User;

public interface UserService {
	public void save(User user);
	public User checkUser(String username, String password);
	public List<User> getAll();
	public void edit(User user);
	public void delete(User user);
}
