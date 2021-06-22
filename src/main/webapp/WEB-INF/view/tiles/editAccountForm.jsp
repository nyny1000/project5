<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<form:form action='<c:url value="/user/edit" />' modelAttribute="accountForm" method="post">
		<form:errors cssClass="error" />
		<br>
		<br>


		<table class="n13">
			<tr>
				<td>�̸�</td>
				<td><form:input path="account.name" /> <form:errors
						path="account.name" cssClass="error" /></td>
			</tr>

			<tr>
				<td>��ȭ��ȣ</td>
				<td><form:input path="account.phone" /> <form:errors
						path="account.phone" cssClass="error" /></td>
			</tr>

			<tr>
				<td>���̵�</td>
				<td><c:if test="${accountForm.newAccount}">
						<form:input path="account.userId" />
						<B><form:errors path="account.userId" cssClass="error" /></B>
					</c:if> <c:if test="${!accountForm.newAccount}">
						<c:out value="${accountForm.account.userId}" />
					</c:if></td>
			</tr>

			<tr>
				<td>�н�����</td>
				<td><form:password path="account.password" /> <B><form:errors
							path="account.password" cssClass="error" /></B></td>
			</tr>

			<tr>
				<td>�н����� Ȯ��</td>
				<td><form:password path="repeatedPassword" /> <B><form:errors
							path="repeatedPassword" cssClass="error" /></B></td>
			</tr>

			<tr>
				<td>�̸���</td>
				<td><form:input path="account.email" /> <form:errors
						path="account.email" cssClass="error" /></td>
			</tr>

			<tr>
				<td>ī���ȣ</td>
				<td><form:input path="account.credit"/> <form:errors
						path="account.credit" cssClass="error" /></td>
			</tr>

			<tr>
				<td>�ּ�</td>
				<td>
				
				
				<form:input path="account.address1" type="text" id="member_addr" readonly="true"/> 
				<input type="button" value="�ּ�ã��" onclick="findAddr()"/>
				<br>
				<form:input path="account.address2" type="text"/>
				<form:errors
						path="account.address2" cssClass="error" /></td>
			</tr>
		</table>

		<br />
		<input type="image" src='<c:url value="../images/button_submit.gif" />' name="submit"
			value="Save Account Information" />
	</form:form>

</div>