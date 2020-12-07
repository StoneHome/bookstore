<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}

h1 a {
	color: red;
}

input {
	text-align: center;
}

.b_edit {
	text-align: center;
}

.edit_div input {
	width: 200px;
}
</style>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="common/img/logo.gif">
		<span class="wel_word">编辑图书</span>
		<%@ include file="/WEB-INF/include/menuManage.jsp"%>
	</div>
	<div id="main">
		<div class="b_edit">
			<form action="/bookManage/updateBook.do" method="post" enctype="multipart/form-data">
				<div class="edit_div"><input type="hidden" name="bookId" value="${book.id }"></div>
				<div class="edit_div"><img class="book_img" src="${book == null ? 'common/img/default.jpg' : book.imgPath }" /></div>
				<div class="edit_div">图片：<input name="book_imgPath" type="file" value="${book.imgPath }"/></div>
				<div class="edit_div">名称：<input name="book_title" type="text" value="${book.title }" /></div>
				<div class="edit_div">作者：<input name="book_author" type="text" value="${book.author }"></div>
				<div class="edit_div">价格：<input name="book_price" type="text" value="${book.price }" /></div>
				<div class="edit_div">销量：<input name="book_sales" type="text" value="${book.sales }" /></div>
				<div class="edit_div">库存：<input name="book_stock" type="text" value="${book.stock }" /></div>
				<div><input type="submit" value="提交" /></div>
			</form>
		</div>
	</div>
	<div id="bottom">
		<span> 网上书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>