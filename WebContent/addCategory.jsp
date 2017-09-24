<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buttons.css">
<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.categoryName.value == "") {
			alert("请输入分类名称");
			document.forms.loginForm.categoryName.focus();
			return false;
		}
	}
</script>
<title>添加分类</title>
</head>
<body>
	<div class="col-md-9 column">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">添加分类</div>
		</div>
		<form action="${pageContext.request.contextPath}/category_add.action" method="post" name="loginForm">
			<div id="formArea">
				<div class="box" style="z-index: 0">
					<label class="item" for="categoryName">分类名称</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="categoryName" name="categoryName"
								tabindex="1" style="z-index: 0" maxlength="24">
						</div>
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