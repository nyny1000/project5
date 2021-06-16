<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <div align="center">
		<form>
      <h1>내 경매 참여 목록</h1>
      <table>
        <tr align="center" bgcolor="#D5D5D5">
          <th>상품ID</th>
          <th>경매 마감일</th>
          <th>최고가</th>
          <th>내 금액</th>
					<th>state</th>
        </tr>
        <tr align="center">
          <td>01</td>
          <td>2021-05-12</td>
          <td>20000</td>
          <td>1000</td>
					<td>경매참여중</td>
        </tr>
				<tr align="center">
          <td>01</td>
          <td>2021-05-12</td>
          <td>20000</td>
          <td>1000</td>
					<td>경매참여중</td>
        </tr>
      </table>
			<h1>내 경매 낙찰 목록</h1>
      <table>
        <tr align="center" bgcolor="#D5D5D5">
          <th>상품ID</th>
          <th>경매 마감일</th>
          <th>낙찰가격</th>
					<th>&nbsp;</th>
        </tr>
        <tr align="center">
          <td>01</td>
          <td>2021-05-12</td>
          <td>20000</td>
					<td>영수증 확인하기</td>
        </tr>
				<tr align="center">
          <td>01</td>
          <td>2021-05-12</td>
          <td>20000</td>
					<td>영수증 확인하기</td>
        </tr>
      </table>
    </form>
  </div>