<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div align="center">
	<form action="center">
		<h1>내 경매 참여 목록입니다</h1>
		<table>
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
					<td><c:out value="${itemList1.state}" /></td>
				</tr>
			</c:forEach>
		</table>
		<h1>내 경매 낙찰 목록</h1>
		<table>
			<tr align="center" bgcolor="#D5D5D5">
				<th>상품ID</th>
				<th>사진</th>
				<th>경매 마감일</th>
				<th>낙찰가격</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach var="itemList1" items="${itemList2.pageList}">
				<tr align="center">
					<td><c:out value="${itemList2.itemId}" /></td>
					<td><img src="<c:out value="${itemList2.picture}" />"  width="200" height="150" /></td>
					<td><fmt:formatDate value="${itemList2.deadline}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><c:out value="${itemList1.auctionedPrice}" /></td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td>01</td>
				<td>2021-05-12</td>
				<td>20000</td>
				<td>영수증 확인하기</td>
			</tr>
			<tr align="center">
				<td>01</td>
				<td>2021-05-12</td>
				<td>20000</td>
				<td>영수증 확인하기</td>
			</tr>
		</table>
	</form>
</div>