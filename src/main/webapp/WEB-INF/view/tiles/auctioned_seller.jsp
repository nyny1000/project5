<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h2>판매되었습니다.</h2>
	<div class="bg">
	<ul class="align">
		<li><b>낙찰품목</b> : <c:out value="${auctionedItem.userId}" /> </li>
		<li><b>가격</b> : <c:out value="${auctionedItem.auctionedPrice}" />원</li>
		<li><b>구매자ID</b> : <c:out value="${auctionedItem.userId}" /></li>
	</ul>
	<p>
	</div>
	<p><a href="<c:url value='/home' />"><input type="button" value="확인"/></a></p>
	
</div>