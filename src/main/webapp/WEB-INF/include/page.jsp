<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="page_nav">
	<c:if test="${page.pageNo > 1 }">
		<a href="${page.path }&pageNo=1">首页</a>
		<a href="${page.path }&pageNo=${page.prev }">上一页</a>
	</c:if>
	<c:choose>
		<c:when test="${page.totalPageNo <= 5 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="${page.totalPageNo }"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="begin" value="${page.pageNo <= 3 ? 1 : page.pageNo - 2 }"></c:set>
			<c:set var="end" value="${page.pageNo >= page.totalPageNo - 2 ? page.totalPageNo : page.pageNo + 2 }"></c:set>
		</c:otherwise>
	</c:choose>
	<c:forEach begin="${begin }" end="${end }" var="index">
		<c:if test="${page.pageNo == index }">
			[<a href="${page.path }&pageNo=${index }">${index }</a>]
		</c:if>
		<c:if test="${page.pageNo != index }">
			<a href="${page.path }&pageNo=${index }">${index }</a>
		</c:if>
	</c:forEach>
	<c:if test="${page.pageNo < page.totalPageNo }">
		<a href="${page.path }&pageNo=${page.next }">下一页</a>
		<a href="${page.path }&pageNo=${page.totalPageNo }">末页</a>
	</c:if>
	共${page.totalPageNo }页，${page.totalRecord }条记录 
	到第<input value="${page.pageNo }" name="pn" id="pn_input"/>页 <input type="button" value="确定" id="inputButton">
	<script type="text/javascript">
		$("#inputButton").click(function(){
			var pageNo = $("#pn_input").val();
			window.location = "${page.path }&pageNo=" + pageNo;
		});
	</script>
</div>