<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div align="center">
	<form action="center">
		<h1>내 경매 참여 목록입니다</h1>
		<table class="table1">
			<tr align="center" bgcolor="#D5D5D5">
				<th>상품ID</th>
				<th>사진</th>
				<th>경매 마감일</th>
				<th>최고가</th>
				<th>내 금액</th>
				<th>state</th>
			</tr>
			
			<c:forEach var="itemList1" items="${itemList1.pageList}">
				<tr align="center">
					<td><c:out value="${itemList1.itemId}" /></td>
					<td><img src="<c:out value="${itemList1.picture}" />"  width="200" height="150" /></td>
					<td><fmt:formatDate value="${itemList1.deadline}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><c:out value="${itemList1.bestPrice}" /></td>
					<td><c:out value="${itemList1.myPrice}" /></td>
					<td><c:if test="${itemList1.state == 0}">
					<a href="<c:url value="/auction/info">
						<c:param name="itemId" value="${itemList1.itemId}" /></c:url>">
						경매참여중</a></c:if>
					<c:if test="${itemList1.state == 1}">
					<a href="<c:url value="/auction/auctioned_buyer">
						<c:param name="itemId" value="${itemList1.itemId}" /></c:url>">
						결제대기중</a></c:if>
					<c:if test="${itemList1.state == 3}">경매실패</c:if></td>	
				</tr>
			</c:forEach>
				<c:if test="${!itemList1.firstPage}">
					<a href="<c:url value="/auction/list/auction">
						<c:param name="page" value="previous" /></c:url>">
				   			<B>&lt;&lt; Prev</B></a>
				</c:if>
				<c:if test="${!itemList1.lastPage}">
					<a href="<c:url value="/auction/list/auction">
						<c:param name="page" value="next" /></c:url>">
				   			<B>Next &gt;&gt;</B></a>
				</c:if>
		</table>
		<h1>내 경매 낙찰 목록입니다</h1>
		<table>
			<tr align="center" bgcolor="#D5D5D5">
				<th>상품ID</th>
				<th>사진</th>
				<th>경매 마감일</th>
				<th>낙찰가격</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach var="itemList2" items="${itemList2.pageList}">
				<tr align="center">
					<td><c:out value="${itemList2.itemId}" /></td>
					<td><img src="<c:out value="${itemList2.picture}" />"  width="200" height="150" /></td>
					<td><fmt:formatDate value="${itemList2.deadline}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><c:out value="${itemList2.auctionedPrice}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>