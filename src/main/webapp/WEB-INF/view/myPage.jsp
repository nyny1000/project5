<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!--  -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Cache-Control" content="max-age=0">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
  <meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="style/petstore.css" type="text/css" />
<!-- 나영 수정1-->                                                 
<title>myPage</title>
</head>
<h1>My Page</h1>
<body bgcolor="white">
	<table class="mypage" border="0" align="center">
		<tr height="100px">
			<td><a href="<c:url value="/auction/list"/>"><button>경매참여목록</button></a></td>
			<td><a href="<c:url value="/user/update"/>"><button>회원정보 수정</button></a></td>
		</tr>

		<tr height="100px">
			<td><a href="<c:url value="/myitem/list"/>"><button>내 그림 관리</button></a></td>
			<td><a href="<c:url value="/user/delete"/>"><button>회원탈퇴</button></a></td>

		</tr>

		<tr height="100px">
			<td><a href="<c:url value="/interesting/list"/>"><button>찜 목록</button></a></td>
		</tr>
	</table>
</body>
</html>