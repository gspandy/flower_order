<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.goodsName.value == "") {
			alert("请输入商品名称");
			document.forms.loginForm.goodsName.focus();
			return false;
		}
	}
</script>
<title>添加鲜花</title>
</head>
<body>
	<div class="col-md-9 column">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">添加鲜花</div>
		</div>
		<form action="${pageContext.request.contextPath}/flower_add.action" method="post" name="loginForm" enctype="multipart/form-data">
			<div id="formArea">
				<div class="box" style="z-index: 0">
					<label class="item" for="goodsName">商品名称</label>
					<div class="ipt_box nick_ipt_box">
						<div class="bg_txt">
							<input type="text" class="new_txt" id="goodsName" name="goodsName"
								tabindex="1" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="description">商品描述</label>
					<div class="ipt_box nick_ipt_box">
						<div class="bg_txt">
							<input type="text" class="new_txt" id="description"
								name="description" tabindex="2" style="z-index: 0">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="price">商品价格</label>
					<div class="ipt_box nick_ipt_box">
						<div class="bg_txt">
							<input type="text" class="new_txt" id="price"
								name="price" tabindex="3" style="z-index: 0">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="category">商品分类</label>
					<div class="ipt_box nick_ipt_box">
<!-- 						<div class="bg_txt"> -->
							<!-- <input type="text" class="new_txt" id="price"
								name="price" tabindex="3" style="z-index: 0"> -->
							<select name="categoryId" id="category" class="bg_select">
								<c:forEach items="${categories}" var="category">
									<option value="${category.id}">${category.categoryName}</option>						
								</c:forEach>
							</select>
<!-- 						</div> -->
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="imgUrl">图片</label>
					<div class="ipt_box nick_ipt_box">
<!-- 						<div class="bg_txt"> -->
							<input type="file" class="new_txt" id="imgUrl" name="imgUrl" tabindex="3" style="z-index: 0">
<!-- 						</div> -->
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<span class="item"></span>
					<div class="ipt_box nick_ipt_box">
						<input type="submit" class="button button-primary button-pill button-small" value="添加" onclick="return check(this);">
					</div>
					<br/>
					<div style="color: red;">
						<p>${message}</p>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>