<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="t1">
	<tr>

		<td><p>&lt;풍경화&gt;</p> <a
			href="<c:url value="/shop/viewCategory?categoryId=landscape" />">
				<img width="130px" height="130px" border="0"
				src="../images/landscape.jpg" />
		</a></td>
		<td><p>&lt;인물화&gt;</p> <a
			href="<c:url value="/shop/viewCategory?categoryId=figure-painting" />">
				<img width="130px" height="130px" border="0"
				src="../images/figure-painting.jpg" />
		</a></td>
		<td><p>&lt;수묵화&gt;</p> <a
			href="<c:url value="/shop/viewCategory?categoryId=ink-and-wash" />">
				<img width="130px" height="130px" border="0"
				src="../images/ink-and-wash.jpg" />
		</a></td>
	</tr>

	<!-- 카테고리 2번째 줄 -->
	<tr>
		<td><p>&lt;추상화&gt;</p> <a 
			href="<c:url value="/shop/viewCategory?categoryId=abstract" />">
				<img width="130px" height="130px" border="0"
				src="../images/abstract.jpg" />
		</a></td>
		<td><p>&lt;정물화&gt;</p> <a
			href="/shop/viewCategory?categoryId=stillLife"> <img
				width="130px" height="130px" border="0"
				src="../images/stillLife.jpg" /></a></td>
		<td><p>&lt;동물화&gt;</p> <a
			href="/shop/viewCategory?categoryId=animalization"> <img
				width="130px" height="130px" border="0"
				src="../images/animalization.png" /></a></td>
	</tr>
</table>