<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h2>상품이름 : <c:out value="${item.itemName}" /> </h2>
	<p>

	<table class="border">
		<tr bgcolor="#FFD700">
			<th>회원ID</th>
			<th>경매가격</th>
		</tr>
		<c:forEach var="buyer" items="${buyers}">
		<tr>
			<td>
				<c:out value="${buyer.key}" />
			</td>
			<td>
				<c:out value="${buyer.value}" />
			</td>
		</c:forEach>
	</table>
	<p>
	희망가격 : <input type="text" /> 
	<a href="<c:url value='/auction/bid' />"><input type="button" value="확인"/></a>
</div>
