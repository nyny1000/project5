<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<div align="center">
		<a href="<c:url value="/shop/viewCategory?categoryId=landscape"/>">풍경화</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=figure-painting"/>">인물화</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=ink-and-wash"/>">수묵화</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=abstract"/>">추상화</a> <img border="0"
			src="../images/separator.gif" /> <a                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			href="<c:url value="/shop/viewCategory?categoryId=stillLife"/>">정물화</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=animalization"/>">동물화</a>
	</div>
	<table class="search">
		<tr>
			<td valign="top" width="100%" style="text-align: center">
				<form action="<c:url value="/search/item"/>" method="post">
					<select name="job">
						<option value="작품명" selected="selected">작품명</option>
						<option value="화가명">화가명</option>
					</select> <input name="keyword" size="50" />&nbsp; <input
						src="../images/search.gif" type="image" />
				</form>
			</td>
		</tr>
	</table>