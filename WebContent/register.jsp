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
		if (document.forms.registerForm.userName.value == "") {
			alert("请输入用户名");
			document.forms.registerForm.userName.focus();
			return false;
		}
		if (document.forms.registerForm.password.value == "") {
			alert("请输入密码");
			document.forms.registerForm.password.focus();
			return false;
		}
	}
</script>
<title>注册</title>
</head>
<body>
	<div class="container">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">注册</div>
		</div>
		<form action="${pageContext.request.contextPath}/user_register.action" method="post" name="registerForm">
			<div id="formArea">
				<div class="box" style="z-index: 0">
					<label class="item" for="userName">用戶名</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="userName" name="userName"
								tabindex="1" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="password">密码</label>
					<div class="ipt_box nick_ipt_box">
						<div id="password_bg" class="bg_txt">
							<input type="password" class="new_txt" id="password"
								name="password" tabindex="2" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="realName">真实姓名</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="realName" name="realName"
								tabindex="3" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="address">地址</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="address" name="address"
								tabindex="4" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="phoneNO">电话号码</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="phoneNO" name="phoneNO"
								tabindex="5" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="email">邮件地址</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="email" name="email"
								tabindex="6" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="pwdQuestion">密保问题</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="pwdQuestion" name="pwdQuestion"
								tabindex="7" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<label class="item" for="pwdQuestionAnswer">密保答案</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_txt">
							<input type="text" class="new_txt" id="pwdQuestionAnswer" name="pwdQuestionAnswer"
								tabindex="8" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box" style="z-index: 0">
					<span class="item"></span>
					<div class="ipt_box nick_ipt_box">
						<input type="submit" class="button button-primary button-pill button-small" value="注册" onclick="return check(this);">
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