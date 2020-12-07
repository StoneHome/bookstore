<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
$(function() {
	// 确认清空
	$(".clearBtn").click(function() {
		var flag = confirm("确认清空吗？");
		if (!flag) {
			return false;
		}
	});
	// 确认删除
	$(".delBtn").click(function() {
		var eleTxt = $(this).parents("tr").find("td:first").text();
		var flag = confirm("确认删除【" + eleTxt + "】吗？");
		if (!flag) {
			return false;
		}
	});
	//更新购物项
	$(".updateInput").change(function() {
		var ele = $(this);
		var id = $(this).attr("id");
		var count = $(this).val();
		$.getJSON("${pageContext.request.contextPath}/cart",{"method":"updateCartItem.do","id":id,"count":count}, function(data){
			ele.parents("tr").find("td:eq(3)").text(data.price);
			$(".b_count").text(data.totalCount);
			$(".b_price").text(data.totalPrice);
		});
	});
});
</script>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="common/img/logo.gif">
		<span class="wel_word">购物车</span>
		<%@ include file="/WEB-INF/include/menuUser.jsp"%>
	</div>
	<div id="main">
		<c:if test="${empty cart.cartItemList }">
			<center>
				<br /><br /><br /><br /><br /><br /><br /><br />
				<h1>
					当前购物车没有图书 ，赶紧去<a href="index.jsp" style="color: blue;">购买</a>吧！
				</h1>
			</center>
		</c:if>
		<c:if test="${!empty cart.cartItemList }">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${cart.cartItemList }" var="item">
					<tr>
						<td>${item.book.title }</td>
						<td>
							<input id="${item.book.id }" class="updateInput" type="text" name="count" value="${item.count }" style="width: 40px;" />
						</td>
						<td>${item.book.price }</td>
						<td>${item.totalPrice }</td>
						<td><a class="delBtn" href="${pageContext.request.contextPath}/cart/deleteCartItem.do?id=${item.book.id }">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${cart.totalPrice }</span>元</span>
				<span class="cart_span"><a class="clearBtn" href="${pageContext.request.contextPath}/cart/clearCartItem.do">清空购物车</a></span>
				<span class="cart_span"><a href="${pageContext.request.contextPath}/orderClient/checkoutOrder.do">去结账</a></span>
			</div>
		</c:if>
	</div>
	<div id="bottom">
		<span> 网上书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>