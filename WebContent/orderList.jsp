<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ page import="com.lian.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function orderDetail(orderId) {	
	window.open("${pageContext.request.contextPath}/ordersDetails_get.action?ordersId=" + orderId, "height=800,width=600,top=0,left=0,toolbar=no")
}
</script>
<title>订单列表</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							用户名
						</th>
						<th>
							商品总数量
						</th>
						<th>
							商品总金额
						</th>
						<th>
							下单时间
						</th>
						<th>
							详细
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="order">
						<tr>
							<td>
								${order.ordersId}
							</td>
							<td>
								${order.user.userName}
							</td>
							<td>
								${order.num}
							</td>
							<td>
								${order.sum}
							</td>
							<td>
								${order.createTime}						
							</td>
							<td>
								<a href="javascript:orderDetail(${order.ordersId})">详细</a>
							</td>
						</tr>
					</c:forEach>										
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>