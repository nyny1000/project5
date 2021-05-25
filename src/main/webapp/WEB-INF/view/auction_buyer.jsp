<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>경매창</title>
<link rel="stylesheet" href="../../../resources/static/style/petstore.css" type="text/css" />
</head>
<body>
<div align="center">
	<h2>상품이름 : 해바라기</h2>
	<p>

	<table class="border">
		<tr bgcolor="#FFD700">
			<th>회원ID</th>
			<th>경매가격</th>
		</tr>
		<tr>
			<td class="bold">김채연</td>
			<td>${}만원</td>
		</tr>
		<tr>
			<td class="bold">반복문</td>
			<td>이용</td>
		</tr>
	</table>
	<p>
	희망가격 : <input type="text" /> 
	<a href="<c:url value='/auction/bid' />"><input type="button" value="확인"/></a>
</div>
</body>
</html>