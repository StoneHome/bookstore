<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
$(function() {
	$(".aDelete").click(function() {
		var $trEle = $(this).parents("tr");
		var title = $trEle.children().first().text();
		var flag = confirm("确定要删除【" + title + "】这本图书吗？");
		if (!flag) {
			//如果点击取消则不让提交请求
			return false;
		}
	});
});
</script>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="common/img/logo.gif">
		<span class="wel_word">图书管理系统</span>
		<%@ include file="/WEB-INF/include/menuManage.jsp"%>
	</div>
	<div id="main">
		<c:if test="${empty page.list }">
				<br><br><br><br><br><br><br><br><br>
				<h1 align="center">没有任何图书</h1>
		</c:if>
		<c:if test="${!empty page.list }">
			<table>
				<tr>
					<td>名称</td>
					<td>价格</td>
					<td>作者</td>
					<td>销量</td>
					<td>库存</td>
					<td colspan="2">操作</td>
				</tr>
				<c:forEach items="${page.list }" var="book">
					<tr>
						<td>${book.title }</td>
						<td>${book.price }</td>
						<td>${book.author }</td>
						<td>${book.sales }</td>
						<td>${book.stock }</td>
						<td><a href="${pageContext.request.contextPath}/bookManage/toUpdateBook.do?id=${book.id }">修改</a></td>
						<td><a href="${pageContext.request.contextPath}/bookManage/deleteBook.do?id=${book.id }" class="aDelete">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
				</tr>
			</table>
		</c:if>
		<!-- 分页信息 -->
		<%@ include file="/WEB-INF/include/page.jsp" %>
	</div>
	<div id="bottom">
		<span> 网上书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>