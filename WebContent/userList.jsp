<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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
							真实姓名
						</th>
						<th>
							地址
						</th>
						<th>
							电话号码
						</th>
						<th>
							邮件地址
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>
								${user.id}
							</td>
							<td>
								${user.userName}
							</td>
							<td>
								${user.realName}
							</td>
							<td>
								${user.address}
							</td>
							<td>
								${user.phoneNO}
							</td>
							<td>
								${user.email}
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