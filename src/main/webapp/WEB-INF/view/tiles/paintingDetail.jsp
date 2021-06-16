<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
   <h2>작품 정보</h2>
   <table>
      <tr>
         <td>작품명</td>
         <td><c:out value="${item.itemName}" /></td>
      </tr>
      <tr>
         <td>카테고리</td>
         <td><c:out value="${item.categoryId}" /></td> <!-- 카테고리 이름으로 바꾸기 -->
      </tr>
      <tr>
         <td>현재 최고가</td>
         <td><c:out value="${item.bestPrice}" /></td>
      </tr>
      <tr>
         <td>화가</td>
         <td><c:out value="${item.artist}" /></td>
      </tr>
      <tr>
         <td>마감 기한</td>
         <td>~<c:out value="${item.deadline}" /></td>
      </tr>
      <tr>
         <td colspan="2"><img src="${item.picture}" /></td>
      </tr>
      <tr>
         <td colspan="2" width="40" height="8"><c:out value="${item.description}" /></td>
      </tr>
   </table>
   <a href="<c:url value="/auction/info">
   		<c:param name="itemId" value="${item.itemId}" /></c:url>">경매 참여</a>

   <c:if test="${isInterested == 0}">
      <a href="<c:url value="/interesting/add">
         <c:param name="itemId" value="${item.itemId}" /></c:url>"> <!-- 고치기 -->
         <img src="/images/iconmonstr-heart-thin-32.png" />
      </a>
   </c:if>

   <c:if test="${isInterested == 1}">
      <a href="<c:url value="/interesting/delete2">
         <c:param name="itemId" value="${item.itemId}" /></c:url>"> <!-- 고치기 -->
         <img src="/images/iconmonstr-favorite-3-32.png" />
      </a>
   </c:if>
</div>
