<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
<h2>작품 검색</h2>	
	<p>
	
	<form action="<c:url value="/search/item" />" method="post">
		<c:out value="전체 검색:" />
		<select name="categoryId">
			<option value="" selected>카테고리</option>
			<c:forEach var="category" items="${categoryList}"> 
				<option value="${category.categoryId}"><c:out value="${category.name}" /></option>
			</c:forEach>
		</select>
		<select name="job">
			<option value="작품명" selected="selected">작품명</option>
			<option value="화가명">화가명</option>
		</select>
		<input type="hidden" name="search" value="true"/>
	    <input type="search" name="keyword" />&nbsp;
	    <input src="/images/search.png" type="image" />
	</form>
</div>

<div align="center">

<c:if test="${!empty categoryName}"><b><c:out value="${categoryName}" /></b>&nbsp;카테고리 내 검색 결과</c:if>
	<%-- <c:if test="${categoryId}"><c:out value="${categoryId }</c:if> --%>
	<p>총 <strong><c:out value="${total}" /></strong> 개의 작품이 검색되었습니다.</p> <!-- 고치기 -->
	<table>
		<th>카테고리</th>
		<th>작품</th>
		<th>제목</th>
		<th>화가</th>
		<c:forEach var="item" items="${itemList.pageList}">
		<tr>
			<td>
				<a href="<c:url value="/shop/viewCategory">
					<c:param name="categoryId" value="${item.categoryId}" /></c:url>">
					<c:out value="${item.categoryId}" />
				</a>
			</td> <!-- 카테고리 이름으로 바꾸기 -->
			<td>
				<a href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>">
					<img src="<c:out value="${item.picture}"/>" width="300" height="200"/>
				</a>
			</td>
			<td>
				<a href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>">
						<c:out value="${item.itemName}" />
				</a>
			</td>
			<td>
				<a href="<c:url value="/search/item">
					<c:param name="artist" value="${item.artist}" /></c:url>">
						<c:out value="${item.artist}" />
				</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center">
				<p>
				<c:if test="${!itemList.firstPage}">
					<a href="<c:url value="/search/item">
						<c:param name="page" value="previous" /></c:url>">
				   			<B>&lt;&lt; Prev</B></a>
				</c:if>
				<c:if test="${!itemList.lastPage}">
					<a href="<c:url value="/search/item">
						<c:param name="page" value="next" /></c:url>">
				   			<B>Next &gt;&gt;</B></a>
				</c:if>
			</td>
		</tr>
	</table>
</div>

<!-- 추가하면 좋을 것들: 정렬기능, 인기검색어 기능 -->