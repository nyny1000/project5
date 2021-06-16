<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h2>
		상품이름 :
		<c:out value="${item.itemName}" />
	</h2>
	<p>
	<table class="border">
		<tr bgcolor="#FFD700">
			<th>회원ID</th>
			<th>경매가격</th>
		</tr>
		<c:forEach var="buyer" items="${buyers}">
			<tr>
				<td><c:out value="${buyer.userId}" /></td>
				<td><c:out value="${buyer.myPrice}" /></td>
		</c:forEach>
	</table>
	<p>
		희망가격 : <input type="text" id="myAuctionPrice" /> 
		<a href="<c:url value="/auction/bid">
         <c:param name="itemId" value="${item.itemId}" />
         <c:param name="price" value="myAuctionPrice.value" /></c:url>"><input
			type="button" value="입찰" /></a>
</div>
