<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<form:form modelAttribute="accountForm" method="post">
		<form:errors cssClass="error" />
		<br>
		<br>


		<table class="n13">
			<tr>
				<td>이름</td>
				<td><form:input path="account.name" /> <form:errors
						path="account.name" cssClass="error" /></td>
			</tr>

			<tr>
				<td>전화번호</td>
				<td><form:input path="account.phone" /> <form:errors
						path="account.phone" cssClass="error" /></td>
			</tr>

			<tr>
				<td>아이디</td>
				<td><c:if test="${accountForm.newAccount}">
						<form:input path="account.userId" />
						<B><form:errors path="account.userId" cssClass="error" /></B>
					</c:if> <c:if test="${!accountForm.newAccount}">
						<c:out value="${accountForm.account.userId}" />
					</c:if></td>
			</tr>

			<tr>
				<td>패스워드</td>
				<td><form:password path="account.password" /> <B><form:errors
							path="account.password" cssClass="error" /></B></td>
			</tr>

			<tr>
				<td>패스워드 확인</td>
				<td><form:password path="repeatedPassword" /> <B><form:errors
							path="repeatedPassword" cssClass="error" /></B></td>
			</tr>

			<tr>
				<td>이메일</td>
				<td><form:input path="account.email" /> <form:errors
						path="account.email" cssClass="error" /></td>
			</tr>

			<tr>
				<td>카드번호</td>
				<td><form:input path="account.credit"/> <form:errors
						path="account.credit" cssClass="error" /></td>
			</tr>

			<tr>
				<td>주소</td>
				<td><input id="member_addr" type="text" placeholder="Address" readonly onclick="findAddr()"/> <br>
				<form:input path="account.address" type="text" placeholder="Detailed Address"/>
				<form:errors
						path="account.address" cssClass="error" /></td>
			</tr>
		</table>

		<br />
		<input type="image" src="../images/button_submit.gif" name="submit"
			value="Save Account Information" />
	</form:form>

</div>