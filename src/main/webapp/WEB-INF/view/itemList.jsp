<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>itemList</title>
</head>
<body>
<div align="center">
	<h2><c:out value="${category.name}" /></h2>
	<form action="<c:url value="/search/item" />" method="post">
		<select name="artist">
			<option value="all" selected>화가명</option>
			<c:forEach var="artist" items="${artistList}">
				<option value="${artist}"><c:out value="${artist}" /></option> <!-- 고치기 -->
			</c:forEach>
		</select>
		<input type="hidden" name="search" value="true"/>
		<input type="hidden" name="categoryId" value="${category.categoryId}" value="true" />
	    <input type="search" name="keyword" />&nbsp;
	    <input src="/images/search.png" type="image" />
	</form>
</div>
<p>
<div align="center">
	<a href="<c:url value="/myitem/add" />">작품 등록</a>
	<a href="<c:url value="/myitem/list" />">내 그림 관리</a>
</div>
<p>

<div align="center">
	<table>
		<th>작품</th>
		<th>제목</th>
		<th>화가</th>
		<c:forEach var="item" items="${itemList.pageList}">
		<tr>
			<td>
				<a href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>">
					<img src="${item.picture}" />
				</a>
			</td>
			<td>
				<a href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>"><c:out value="${item.itemName}" /></a>
			</td>
			<td>
				<a href="<c:url value="/search/item">
					<c:param name="artist" value="${item.artist}" /></c:url>"><c:out value="${item.artist}" /></a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center">
				<p>
				<c:if test="${!itemList.firstPage}">
					<a href="<c:url value="/shop/viewCategory2">
						<c:param name="page" value="previous" /></c:url>">
				   			<B>&lt;&lt; Prev</B></a>
				</c:if>
				<c:if test="${!itemList.lastPage}">
					<a href="<c:url value="/shop/viewCategory2">
						<c:param name="page" value="next" /></c:url>">
				   			<B>Next &gt;&gt;</B></a>
				</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>