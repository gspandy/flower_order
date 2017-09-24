<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function buy(item, num) {
		var items = '<%=request.getAttribute("aaa")%>';
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<!-- <div class="container">
		<div class="row"> -->
			<div class="col-md-9 column">
				<div class="row">
					<c:forEach items="${goods}" var="good">
						<div class="col-md-4" style="width:33%;display:inline-block;">
							<div class="thumbnail">
								<a href="#">
									<img alt="300x200" src="${pageContext.request.contextPath}/${good.imgUrl}"/>									
								</a>
								<div class="caption">
									<h3>
										${good.goodsName}
									</h3>
									<p>
										￥${good.price}
									</p>
									<!-- <p>
																		
									</p> -->
									<form action="${pageContext.request.contextPath}/put_cart.action" method="post">
										<label>数量</label>
										<input type="text" name="num" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" style="width:50px;"/>
										<input type="hidden" name="goodsId" value="${good.id}"/>
										<input type="submit" class="btn btn-primary" value="加入购物车"/>
									</form>
								</div>
							</div>
						</div>
					</c:forEach>				
				</div>
			</div>
	<!-- 	</div>
	</div> -->
</body>
</html>