<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- include_top.jsp될부분 시작 -->
	<table class="top">
		<tr>
			<td><a href="shop/index.do"> <img border="0"
					src="images/artsell_logo_white.jpg" /></a></td>
			<td style="text-align: right"><a href="shop/viewCart.do"> <img
					border="0" name="img_cart" src="images/cart.gif" /></a> <img
				border="0" src="images/separator.gif" /> <a href="/user/logout">
					<button>로그아웃</button>
			</a> <img border="0" src="images/separator.gif" />&nbsp; <a href="..">
					<button>마이페이지</button>
			</a> <img border="0" src="images/separator.gif" />&nbsp; <a href="..">
					<button>경매현황</button>
			</a></td>
		</tr>
		<tr>
			<td></td>
			<td style="text-align: right"><a href="..">
					<button>그림 등록</button>
			</a> <img border="0" src="images/separator.gif" />&nbsp; <a href="..">
					<button>내 그림 관리</button>
			</a></td>
		</tr>
	</table>
	<!-- include_top.jsp될부분 끝 -->


	<!-- include_search.jsp될부분 시작 -->
	<div align="center">
		<a href="shop/index.do">풍경화</a> <img border="0"
			src="images/separator.gif" /> <a href="shop/index.do">인물화</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">수묵화</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">추상화</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">정물화</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">동물화</a> 
	</div>
	<table class="search">
		<tr>
			<td valign="top" width="100%" style="text-align: center">
				<form action="shop/searchProducts.do" method="post">
					<select name="job">
						<option value="작품명" selected="selected">작품명</option>
						<option value="화가명">화가명</option>
					</select> <input name="keyword" size="50" />&nbsp; <input
						src="images/search.gif" type="image" />
				</form>
			</td>
		</tr>
	</table>
	<!-- include_search.jsp될부분 끝 -->

	<!-- body가 될부분 시작. -->
	<table class="t1">
		<tr>

			<td><p>&lt;풍경화&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/landscape.jpg" /></a></td>
			<td><p>&lt;인물화&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/figure-painting.jpg" /></a></td>
			<td><p>&lt;수묵화&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/ink-and-wash.jpg" /></a></td>
		</tr>

		<!-- 카테고리 2번째 줄 -->
		<tr>
			<td><p>&lt;추상화&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/abstract.jpg" /></a></td>
			<td><p>&lt;정물화&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/stillLife.jpg" /></a></td>
			<td><p>&lt;동물화&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/animalization.png" /></a></td>
		</tr>
	</table>
	<!-- body 부분 끝 -->


	<!-- include_bottom.jsp될 부분 시작-->
	<div align="center">
		<table>
			<tr>
				<td><a href="http://www.springframework.org"> <img
						border="0" src="images/spring-logo.png"
						alt="Powered by the Spring Framework" /></a></td>
				<td><a href="http://www.ibatis.com"> <img border="0"
						src="images/mybatis-logo.png" alt="Powered by MyBatis" /></a></td>
			</tr>
		</table>
	</div>
	<!-- include_bottom.jsp될 부분 끝-->
</body>
</html>