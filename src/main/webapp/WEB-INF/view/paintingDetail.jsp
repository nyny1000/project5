<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>작품 정보</h2>
	<table>
		<tr>
			<td>작품명</td>
			<td th:text="${item.itemName}">제목</td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td th:text="${item.categoryId}">카테고리</td> <!-- 카테고리 이름으로 바꾸기 -->
		</tr>
		<tr>
			<td>현재 최고가</td>
			<td th:text="${item.bestPrice}">최고가</td>
		</tr>
		<tr>
			<td>화가</td>
			<td th:text="${item.artist}">화가</td>
		</tr>
		<tr>
			<td>마감 기한</td>
			<td th:text="${item.deadline}">마감기한</td>
		</tr>
		<tr>
			<td colspan="2"><img src="${item.picture}" /></td>
		</tr>
		<tr>
			<td colspan="2" width="40" height="8" th:text="${item.description}">그림 설명</td>
		</tr>
	</table>
	<a href="" th:href="@{/auction/info}">경매 참여</a>
	<a href="" th:unless="(찜한 목록에 있으면)" th:href="@{/interesting/add}"> <!-- 고치기 -->
		<img src="../../static/images/iconmonstr-heart-thin-32.png" />
	</a>
	<a href="" th:if="(찜한 목록에 있으면)" th:href="@{/interesting/delete}"> <!-- 고치기 -->
		<img src="../../static/images/iconmonstr-favorite-3-32.png" />
	</a>
</div>
</body>
</html>