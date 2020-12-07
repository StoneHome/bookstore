<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}

h1 a {
	color: red;
}
</style>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="common/img/logo.gif">
		<span class="wel_word">注册成功</span>
		<%@ include file="/WEB-INF/include/menuUser.jsp"%>
	</div>
	<div id="main">
		<h1>
			注册成功!
			<a href="index.jsp">转到主页</a>
		</h1>
	</div>
	<div id="bottom">
		<span> 网上书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>