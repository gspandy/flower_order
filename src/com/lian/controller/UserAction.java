package com.lian.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lian.entity.Admin;
import com.lian.entity.User;
import com.lian.service.AdminService;
import com.lian.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	

	private User user = new User();
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="adminService")
	private AdminService adminService;
	private HttpServletRequest request;
	
	@Override
	public User getModel() {
		return user;
	}	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	public String add() throws Exception {
		request = ServletActionContext.getRequest();
		try {
			userService.save(user);
			request.setAttribute("message", "注册成功");
			return "success";
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "注册失败");
			return "failure";
		}		
	}
	
	public String login() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromDb = userService.checkUser(user.getUserName(), user.getPassword());
		if (userFromDb != null) {
			request.getSession().setAttribute("loginUser", userFromDb.getUserName());
			return "success";
		} else {
			Admin adminFromDb = adminService.checkAdmin(user.getUserName(), user.getPassword());
			if (adminFromDb != null) {
				request.getSession().setAttribute("loginUser", adminFromDb.getUsername());
				return "success";
			} else {
				request.setAttribute("error", "用户名或密码错误");
				return "failure";
			}			
		}
	}
	
	public String logout() throws Exception {
		request = ServletActionContext.getRequest();
		request.getSession().invalidate();
		return "success";
	}
	
	public String getAll() throws Exception {
		request = ServletActionContext.getRequest();
		List<User> users = userService.getAll();
		request.setAttribute("users", users);
		return "success";
	}
	
	public String edit() throws Exception {
		request = ServletActionContext.getRequest();
		try {
			userService.edit(user);
			List<User> users = userService.getAll();
			request.setAttribute("users", users);
			return "success";
		} catch(Exception e) {
			return "failure";
		}
	}
	
	public String delete() throws Exception {
		request = ServletActionContext.getRequest();
		try {
			userService.delete(user);
			List<User> users = userService.getAll();
			request.setAttribute("users", users);
			return "success";
		} catch(Exception e) {
			return "failure";
		}
	}
	
	

}
