<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../style/petstore.css" type="text/css" />

</head>
<body>
	<!-- include_top.jsp될부분 시작 -->
	<table class="top">
		<tr>
			<td><a href="<c:url value="/home"/>"> <img border="0"
					src="/images/artsell_logo_white.jpg" /></a></td>
			<td style="text-align: right">
			<%-- <c:out value="${userSession.account.userId}" /> --%> <!-- cnrk -->
			<c:if test="${empty userSession.account}">
					<a href="<c:url value='/user/register'/>">
						<button>회원가입</button>
					</a>
					</c:if>
					<c:if test="${empty userSession.account}">
					<a href="<c:url value='/user/login'/>">
						<button>로그인</button>
					</a>
					</c:if>
			<c:if
					test="${!empty userSession.account}">
					<a href="<c:url value="/user/logout"/>">
						<button>로그아웃</button>
					</a>
					<img border="0" src="/images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/update"/>">
						<button>회원정보수정</button>
					</a>
						<img border="0" src="/images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/delete"/>">
						<button>회원탈퇴</button>
					</a>
					<img border="0" src="/images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/mypage"/>">
						<button>마이페이지</button>
					</a>
					<img border="0" src="/images/separator.gif" />&nbsp; <a
						href="<c:url value="/auction/list"/>">
						<button>경매현황</button>
					</a>
				</c:if></td>
		</tr>
		<tr>
			<td></td>
			<c:if test="${!empty userSession.account}">
				<td style="text-align: right"><a
					href="<c:url value="/myitem/add"/>">
						<button>그림 등록</button>
				</a> <img border="0" src="/images/separator.gif" />&nbsp; <a
					href="<c:url value="/myitem/list"/>">
						<button>내 그림 관리</button>
				</a></td>
			</c:if>
		</tr>
	</table>
	<!-- include_top.jsp될부분 끝 -->


	<!-- include_search.jsp될부분 시작 -->
	<div align="center">
		<a href="<c:url value="/shop/viewCategory?categoryId=landscape"/>">풍경화</a> <img border="0"
			src="/images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=figure-painting"/>">인물화</a> <img border="0"
			src="/images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=ink-and-wash"/>">수묵화</a> <img border="0"
			src="/images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=abstract"/>">추상화</a> <img border="0"
			src="/images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=stillLife"/>">정물화</a> <img border="0"
			src="/images/separator.gif" /> <a
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
						src="/images/search.gif" type="image" />
				</form>
			</td>
		</tr>
	</table>
	<!-- include_search.jsp될부분 끝 -->

	<!-- body가 될부분 시작. -->
	<table class="t1">
		<tr>

			<td><p>&lt;풍경화&gt;</p> <a
				href="<c:url value="/shop/viewCategory?categoryId=landscape" />">
					<img width="130px" height="130px" border="0"
					src="/images/landscape.jpg" />
			</a></td>
			<td><p>&lt;인물화&gt;</p> <a
				href="<c:url value="/shop/viewCategory?categoryId=figure-painting" />">
					<img width="130px" height="130px" border="0"
					src="/images/figure-painting.jpg" />
			</a></td>
			<td><p>&lt;수묵화&gt;</p> <a
				href="<c:url value="/shop/viewCategory?categoryId=ink-and-wash" />">
					<img width="130px" height="130px" border="0"
					src="/images/ink-and-wash.jpg" />
			</a></td>
		</tr>

		<!-- 카테고리 2번째 줄 -->
		<tr>
			<td><p>&lt;추상화&gt;</p> <a
				href="<c:url value="/shop/viewCategory?categoryId=abstract" />">
					<img width="130px" height="130px" border="0"
					src="/images/abstract.jpg" />
			</a></td>
			<td><p>&lt;정물화&gt;</p> <a
				href="/shop/viewCategory?categoryId=stillLife"> <img
					width="130px" height="130px" border="0" src="/images/stillLife.jpg" /></a></td>
			<td><p>&lt;동물화&gt;</p> <a
				href="/shop/viewCategory?categoryId=animalization"> <img
					width="130px" height="130px" border="0"
					src="/images/animalization.png" /></a></td>
		</tr>
	</table>
	<!-- body 부분 끝 -->


	<!-- include_bottom.jsp될 부분 시작-->
	<div align="center">
		<table>
			<tr>
				<td><a href="http://www.springframework.org"> <img
						border="0" src="/images/spring-logo.png"
						alt="Powered by the Spring Framework" /></a></td>
				<td><a href="http://www.ibatis.com"> <img border="0"
						src="/images/mybatis-logo.png" alt="Powered by MyBatis" /></a></td>
			</tr>
		</table>
	</div>
	<!-- include_bottom.jsp될 부분 끝-->
</body>
</html>