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
				<th>그림</th>
				<th>경매 마감일</th>
				<th>최고가</th>
				<th>내 금액</th>
				<th>state</th>
			</tr>
			
			<c:forEach var="AuctionItem" items="${AuctionList.pageList}">
				<tr align="center">
					<td><c:out value="${AuctionItem.itemId}" /></td>
					<td><img src="<c:out value="${AuctionItem.picture}" />"  width="200" height="150" /></td>
					<td><fmt:formatDate value="${AuctionItem.deadline}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><c:out value="${AuctionItem.bestPrice}" /></td>
					<td><c:out value="${AuctionItem.myPrice}" /></td>
					<td><c:out value="${AuctionItem.state}" /></td>
			</c:forEach>
		</table>
		<h1>내 경매 낙찰 목록</h1>
		<table>
			<tr align="center" bgcolor="#D5D5D5">
				<th>상품ID</th>
				<th>경매 마감일</th>
				<th>낙찰가격</th>
				<th>&nbsp;</th>
			</tr>
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