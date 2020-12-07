<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty sessionScope.loginUser }">
	<div>
		<a href="pages/user/login.jsp">登录</a> | 
		<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
		<a href="pages/cart/cart.jsp">购物车</a>
		<a href="manage.jsp">后台管理</a>
	</div>
</c:if>
<c:if test="${!empty sessionScope.loginUser }">
	<div>
		<span>欢迎<span class="um_span">${sessionScope.loginUser.username }</span>光临网上书城</span>
		<a href="${pageContext.request.contextPath}/user/logout.do">注销</a>&nbsp;&nbsp;
		<a href="pages/cart/cart.jsp">购物车</a>
		<a href="${pageContext.request.contextPath}/orderClient/getClientOrderList.do">我的订单</a>
		<a href="index.jsp">返回</a>
	</div>
</c:if>