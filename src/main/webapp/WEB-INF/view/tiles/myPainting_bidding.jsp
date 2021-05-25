<!-- xml에도 추가해야 함. -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="itembidding">
		<h2>최소가격의 30% 감소하여 다시 올리시겠습니까?</h2>
		<h3>가격: ______ -> ______</h3>
		<h3>마감기간:</h3>
	</div>
	<table class="biddingcheck" align="center">
		<tr>
			<td><a href="..">
					<button>예</button></td>
			<td><a href="..">
					<button>아니오</button></td>
		</tr>
	</table>
</body>