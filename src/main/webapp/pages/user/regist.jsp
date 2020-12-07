<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
$(function() {
	$("#sub_btn").click(function() {
		//获取用户输入的用户名
		var username = $("#username").val();
		//声明验证用户名的正则表达式
		var usernameReg = /^[a-zA-Z0-9_-]{3,16}$/;
		var flag = usernameReg.test(username);
		if (!flag) {
			alert("用户名要保证3-16位字母、数字、减号、下划线的组合");
			//取消默认行为
			return false;
		}
		var password = $("#password").val();
		var pwdReg = /^[a-zA-Z0-9_-]{6,18}$/;
		if (!pwdReg.test(password)) {
			alert("密码要保证6-18位字母、数字、减号、下划线的组合");
			return false;
		}
		//获取用户输入的确认密码
		var comfirmPwd = $("#repwd").val();
		//判断确认密码是否与密码相等
		if (comfirmPwd != password) {
			$("#repwd").val("");
			alert("两次密码不一致！");
			return false;
		}
		//获取用户输入的邮箱
		var email = $("#email").val();
		//声明验证邮箱的正则表达式
		var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		//使用正则表达式对邮箱进行验证
		var emailFlag = emailReg.test(email);
		//如果不符合要求
		if (!emailFlag) {
			alert("邮箱格式不正确！");
			return false;
		}
		//获取用户输入的验证码
		var code = $("#code").val();
		if (code == "") {
			alert("验证码不能为空！");
			return false;
		}
	});

	//点击切换验证码
	$("#imgCode").click(function(){
		this.src = "KaptchaServlet";
	});

	//检查用户名
	$("#username").change(function(){
		var username = $(this).val();
		$.get("${pageContext.request.contextPath}/user/checkUsername.do?username=" + username, function(data){
			if(data == 0){
				$(".errorMsg").html("<b style='color:green'>用户名可以使用</b>");
			}else{
				$(".errorMsg").html("<b style='color:red'>用户名已存在</b>");
				$("#username").focus();
			}
		});
	});
});
</script>
<style type="text/css">
.login_form {
	height: 420px;
	margin-top: 25px;
}
</style>
</head>
<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="common/img/logo.gif">
	</div>
	<div class="login_banner">
		<div id="l_content">
			<span class="login_word">欢迎注册</span>
		</div>
		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>注册商城会员</h1>
						<%-- <span class="errorMsg"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span> --%>
						<span class="errorMsg">${message }</span>
					</div>
					<div class="form">
						<form action="/user/regist.do" method="post">
							<label>用户名称：</label>
							<input value="${param.username }" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
							<br />
							<br />
							<label>用户密码：</label>
							<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
							<br />
							<br />
							<label>确认密码：</label>
							<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
							<br />
							<br />
							<label>电子邮件：</label>
							<input value="${param.email }" class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
							<br /> 
							<br />
							<label>验证码：</label>
							<input class="itxt" type="text" style="width: 150px;" name="code" id="code" />
							<img id="imgCode" alt="" src="KaptchaServlet" style="float: right; margin-right: 40px;width: 80px;height: 40px;">
							<br />
							<br />
							<input type="submit" value="注册" id="sub_btn" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="bottom">
		<span> 网上书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>