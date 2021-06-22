<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <script type="text/javascript">
$(document).ready(function() {
	var userSession = '<%=session.getAttribute("userSession")%>'
	if (userSession == null) {
		var reLogin = confirm('������ ����Ǿ����ϴ�. Ȯ�� �� �α���â���� �̵��մϴ�.');
		document.write("���Ǹ���");
		if (reLogin) {
			location.href = '/user/login';
		}
	}
});
</script> --%>
<div class="content-topbar">
	<a href="<c:url value="/home"/>" class="left-topbar-item"><img border="0"
				src='<c:url value="../images/artsell_logo_white.jpg" />'/></a>
	<div class="left-topbar">
		<c:if test="${!empty userSession.account}">
			<a href="javascript:void(0);" class="left-topbar-item"><c:out value="${userSession.account.userId}"/>��.</a>
			<a href="<c:url value="/user/logout"/>" class="left-topbar-item">�α׾ƿ�</a>
			<c:if test="${userSession.account.userId eq 'admin'}">
				<a href="<c:url value="/admin/manage"/>" class="left-topbar-item">ȸ������</a>
				<a href="<c:url value="/interesting/list"/>" class="left-topbar-item">����</a>
			</c:if>
			<c:if test="${userSession.account.userId ne 'admin'}">
				<a href="<c:url value="/user/mypage"/>" class="left-topbar-item">����������</a>
			</c:if>
			<a href="<c:url value="/auction/list"/>" class="left-topbar-item">����������</a>
			<a href="<c:url value="/myitem/add"/>" class="left-topbar-item">��ǰ���</a>
			<a href="<c:url value="/myitem/list"/>" class="left-topbar-item">����ǰ����</a>
		</c:if>
	</div>
</div>

<%--<table class="top">
	<tr>
		<td><a href="<c:url value="/home"/>"> <img border="0"
				src="../images/artsell_logo_white.jpg" /></a></td>
		<td style="text-align: right">
			<!-- <c:out value="${userSession.account.userId}" /> cnrk -->
			<c:if test="${!empty userSession.account}">
				<a href="<c:url value="/user/logout"/>">
					<button>�α׾ƿ�</button>
				</a>
				<c:if test="${userSession.account.userId eq 'admin'}">
					<img border="0" src="../images/separator.gif" />&nbsp; <a
						href="<c:url value="/admin/manage"/>">
						<button>ȸ������</button>
					</a>
					<img border="0" src="../images/separator.gif" />&nbsp; 
						<a href="<c:url value="/interesting/list"/>">
						<button>����</button>
					</a>
				</c:if>
				<c:if test="${userSession.account.userId ne 'admin'}">
					<img border="0" src="../images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/mypage"/>">
						<button>����������</button>
					</a>
				</c:if>
				<img border="0" src="../images/separator.gif" />&nbsp; <a
					href="<c:url value="/auction/list"/>">
					<button>�����Ȳ</button>
				</a>
			</c:if>
		</td>
	</tr>
	<tr>
		<td></td>
		<c:if test="${!empty userSession.account}">
			<td style="text-align: right"><a
				href="<c:url value="/myitem/add"/>">
					<button>�׸� ���</button>
			</a> <img border="0" src="../images/separator.gif" />&nbsp; <a
				href="<c:url value="/myitem/list"/>">
					<button>�� �׸� ����</button>
			</a></td>
		</c:if>
	</tr>
</table>
--%>
