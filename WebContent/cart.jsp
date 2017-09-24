<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>
							商品名称
						</th>
						<th>
							商品单价
						</th>
						<th>
							购买数量
						</th>
					</tr>
				</thead>
				<tbody>					
					<c:forEach items="${cart.items}" var="item">						
						<tr>
							<td>
								${item.value.goodsName}
							</td>
							<td>
								${item.value.price}
							</td>							
							<td>
								<form action="${pageContext.request.contextPath}/update_cart.action" method="post">
									<input type="text" name="num" value="${item.value.num}"  onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" style="width:50px;"/>
									<input type="hidden" name="goodsId" value="${item.key}"/>	
									<input type="submit" value="更新" class="btn btn-primary" />							
								</form>
							</td>					
						</tr>						
					</c:forEach>										
				</tbody>
			</table>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form action="${pageContext.request.contextPath}/order_order.action" method="post">
				<input type="submit" value="购买" class="btn btn-success btn-default" style="float:right"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>