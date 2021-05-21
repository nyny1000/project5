<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>myPaintingList</title>
	<style>
    table, tr, th{
      border: 2px solid black;
      border-collapse: collapse;
    }
    table, tr, td{
      border: 1px solid black;
      border-collapse: collapse;
    }
	</style>
</head>

<body>
  <div align="center">
		<form>
      <h1>내 그림 관리</h1>
      <table>
        <tr align="center" bgcolor="#D5D5D5">
          <th>상품ID</th>
          <th width="200px">상품이미지</th>
          <th>state</th>
          <th>&nbsp;</th>
        </tr>
        <tr align="center">
          <td>01</td>
          <td><input name="pic" type="image" src="../../../resources/static/images/t1.jpg" width="100px"></td>
          <td>경매중</td>
          <td>그림등록취소</td>
        </tr>
        <tr>
	      <td>
		      <c:if test="${!myPaintList.firstPage}">
		          <a href='<c:url value="/myitem/list2">
		            <c:param name="page" value="previous"/></c:url>'>
		              <B>&lt;&lt; Prev</B></a>
		      </c:if> 
	        <c:if test="${!myPaintList.lastPage}">
	          <a href='<c:url value="/myitem/list2">
	            <c:param name="page" value="next"/></c:url>'>
	              <B>Next &gt;&gt;</B></a>
	        </c:if>
	      </td>
		</tr>
      </table>
    </form>
  </div>
</body>
