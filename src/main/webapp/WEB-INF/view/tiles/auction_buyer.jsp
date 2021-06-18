<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
   <h2>
      상품이름 :
      <c:out value="${item.itemName}" />
   </h2>
   <p>
   <table class="border">
      <tr bgcolor="#FFD700">
         <th>회원ID</th>
         <th>경매가격</th>
      </tr>
      <c:forEach var="buyer" items="${buyers}">
         <tr>
            <td><c:out value="${buyer.userId}" /></td>
            <td><c:out value="${buyer.myPrice}" /></td>
      </c:forEach>
   </table>
   <p>
   
   <!--<form action="<c:url value='/auction/bid'/>" method="POST">
      <form:errors cssClass="error" />
      <input type="text" name="myAuctionPrice" />
      <form:errors path="bidder.price" cssClass="error" />
      <input type="hidden" name="itemId" value="${item.itemId}" /> <input
         type="submit" value="입찰" />
   </form>-->
         <form:form action="<c:url value='/auction/bid'/>"
         modelAttribute="auctionItem" method="POST">
         <form:errors cssClass="error" />
         <form:input type="text" path="myPrice" />
         <form:errors path="myPrice" cssClass="error" />
         <form:input type="hidden" path="itemId" value="${item.itemId}" />


         <input type="submit" value="입찰" />

      </form:form>

</div>