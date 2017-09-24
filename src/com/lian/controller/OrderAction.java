package com.lian.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lian.entity.Good;
import com.lian.entity.Order;
import com.lian.entity.OrdersDetail;
import com.lian.entity.User;
import com.lian.service.GoodsService;
import com.lian.service.OrderService;
import com.lian.util.Cart;
import com.opensymphony.xwork2.ActionSupport;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends ActionSupport {
	@Resource(name="orderService")
	private OrderService orderService;
	@Resource(name="goodsService")
	private GoodsService goodsService;
	private HttpServletRequest request;
	private String ordersId;
	private String num;
	private String goodsId;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getAllOrders() throws Exception {
		request = ServletActionContext.getRequest();
		List<Order> orders = orderService.getAll();
		request.setAttribute("orders", orders);
		return "success";
	}
	
	public String getOrdersDetail() throws Exception {
		request = ServletActionContext.getRequest();
		List<OrdersDetail> ordersDetails = orderService.getOrderDetailByOrderId(Integer.valueOf(ordersId));
		request.setAttribute("ordersDetails", ordersDetails);
		return "success";
	}
	
	public String addToCart() throws Exception {
		request = ServletActionContext.getRequest();
		Good good = goodsService.getById(Integer.valueOf(goodsId));
		OrdersDetail ordersDetail = new OrdersDetail();
		ordersDetail.setGoodsName(good.getGoodsName());
		ordersDetail.setNum(Integer.valueOf(num));
		ordersDetail.setPrice(good.getPrice());
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		cart.addGoods(Integer.valueOf(goodsId), ordersDetail);
		request.getSession().setAttribute("cart", cart);
		return "success";
	}
	
	public String updateCart() throws Exception {
		request = ServletActionContext.getRequest();
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.updateCart(Integer.valueOf(goodsId), Integer.valueOf(num));
		request.getSession().setAttribute("cart", cart);
		return "success";
	}
	
	public String order() throws Exception {
		request = ServletActionContext.getRequest();
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null || cart.getItems().size() == 0) {
			return "failure";
		}
		String username = (String) request.getSession().getAttribute("loginUser");
		User user = new User();
		user.setUserName(username);
		Order order = new Order();
		order.setUser(user);
		order.setNum(cart.getTotalNum());
		order.setSum(cart.getTotalPrice());
		order.setCreateTime(new Date());
		HashSet set = new HashSet();
		set.addAll(cart.getItems().values());
		order.setOrdersDetails(set);
		orderService.saveOrder(order);
		request.getSession().removeAttribute("cart");
		return "success";
	}

}
