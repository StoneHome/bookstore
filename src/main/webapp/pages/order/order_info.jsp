<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="common/img/logo.gif">
		<span class="wel_word">订单详情</span>
		<%@ include file="/WEB-INF/include/menuUser.jsp"%>
	</div>
	<div id="main">
		<c:if test="${empty orderItems }">
			<h1>您还没有任何订单。赶快<a href="index.jsp">购买吧</a></h1>
		</c:if>
		<c:if test="${!empty orderItems }">
			<table>
				<tr>
					<td>书名</td>
					<td>作者</td>
					<td>价格</td>
					<td>数量</td>
					<td>金额</td>
				</tr>	
				<c:forEach items="${orderItems }" var="item">	
					<tr>
						<td>${item.title }</td>
						<td>${item.author }</td>
						<td>${item.price }</td>
						<td>${item.count }</td>
						<td>${item.totalPrice }</td>
					</tr>
				</c:forEach>		
			</table>
		</c:if>
	</div>
	<div id="bottom">
		<span> 网上书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>