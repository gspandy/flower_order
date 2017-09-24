<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鲜花订购系统</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column"></div>
		</div>
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="list-group">
					<c:choose>
						<c:when test="${loginUser eq 'admin'}">
							<div class="list-group-item active">鲜花管理</div>
							<a href="${pageContext.request.contextPath}/addCategory.jsp" class="list-group-item" target="main_iframe">添加种类</a>
							<a href="${pageContext.request.contextPath}/open_add_flower.action" class="list-group-item" target="main_iframe">添加鲜花</a>
							<a href="${pageContext.request.contextPath}/open_flower_list.action" class="list-group-item" target="main_iframe">鲜花列表</a>
							<div class="list-group-item active">用户管理</div>
							<a href="${pageContext.request.contextPath}/user_get_all.action" class="list-group-item" target="main_iframe">用户列表</a>
							<a href="${pageContext.request.contextPath}/order_get_all.action" class="list-group-item" target="main_iframe">订单列表</a>
							<a href="${pageContext.request.contextPath}/user_logout.action" class="list-group-item active">退出</a>
						</c:when>
						<c:otherwise>
							<div class="list-group-item active">种类</div>
							<c:forEach items="${categories}" var="category">
								<a href="${pageContext.request.contextPath}/goods_get.action?categoryId=${category.id}" class="list-group-item" target="main_iframe">${category.categoryName}</a>
							</c:forEach>
							<div class="list-group-item active">高级查询</div>
							<div class="list-group-item">
								<form action="${pageContext.request.contextPath}/goods_get.action" method="get" target="main_iframe">
									<label for="keyword">关键词</label>
									<input type="text" name="keyword" id="keyword"><br/>
									<label for="category">种类</label>
									<select name="categoryId" id="category">
										<option value=""></option>
										<c:forEach items="${categories}" var="category">
											<option value="${category.id}">${category.categoryName}</option>						
										</c:forEach>
									</select>
									<br/>
									<label for="minPrice">价格</label>
									<input type="text" id="minPrice" name="minPrice" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" style="width:50px">
									<label for="maxPrice">-</label>
									<input type="text" id="maxPrice" name="maxPrice" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" style="width:50px">
									<br/>
									<input type="submit" class="btn btn-primary" value="确定">
								</form>								
							</div>
							<a href="${pageContext.request.contextPath}/cart.jsp" class="list-group-item active" target="main_iframe">购物车</a>
							<a href="${pageContext.request.contextPath}/user_logout.action" class="list-group-item active">退出</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="col-md-9 column">
				<c:choose>
					<c:when test="${loginUser eq 'admin'}">
						<iframe frameborder="0" name="main_iframe" src="${pageContext.request.contextPath}/addCategory.jsp" width="100%" height="1000px"></iframe>
					</c:when>
					<c:otherwise>
						<iframe frameborder="0" name="main_iframe" src="${pageContext.request.contextPath}/goods_get.action" width="100%" height="1000px"></iframe>
					</c:otherwise>
				</c:choose>					
				
			</div>
		</div>
	</div>
</body>
</html>