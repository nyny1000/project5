<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>myInterestingList</title>
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
      <h1>나의 찜 목록</h1>
      <table>
        <tr align="center" bgcolor="#D5D5D5">
          <th>상품ID</th>
          <th>상품이름</th>
          <th>경매 마감일</th>
          <th>최고가</th>
          <th>&nbsp;</th>
					<th>삭제</th>
        </tr>

        <c:forEach var="interestItem" items="${interestList.pageList}">
	        <tr align="center">
	          <td><c:out value="${interestItem.itemId}" /></td>
	          <td><c:out value="${interestItem.itemName}" /></td>
	          <td><fmt:formatDate value="${interestItem.deadline}" pattern="yyyy-MM-dd" /></td>
	          <td><c:out value="${interestItem.bestPrice}" /></td>
	          <td>
	          	<a href='<c:url value="/aution/info">
            		<c:param name="itemId" value="${interestItem.itemId}"/></c:url>'>
             		<c:out value="경매하기" />
         		</a>
	          </td>
	          	
			  <td><a href='<c:url value="/interesting/delete">
			  <c:param name="interItemId" value="${interestItem.itemId}"/></c:url>'>
             		<c:out value="삭제하기" />
         		</a></td>
	        </tr>
	    </c:forEach>
	    <tr>
	      <td>
		      <c:if test="${!interestList.firstPage}">
		          <a href='<c:url value="/interesting/list2">
		            <c:param name="page" value="previous"/></c:url>'>
		              <B>&lt;&lt; Prev</B></a>
		      </c:if> 
	        <c:if test="${!interestList.lastPage}">
	          <a href='<c:url value="/interesting/list2">
	            <c:param name="page" value="next"/></c:url>'>
	              <B>Next &gt;&gt;</B></a>
	        </c:if>
	      </td>
		</tr>
      </table>
    </form>
  </div>
</body>
