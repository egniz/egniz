<%@page import="com.naver.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<header>
	<%
		Object obj = session.getAttribute("login");
		if (obj != null) {
			MemberDTO dto = (MemberDTO) obj;
	%>
	<%=dto.getName()%>
	<!-- out.print(dto.getName()); �� �κ��� ���� �ٷ� �����-->
	��, ȯ���մϴ�. <a href='logout.do'>�α׾ƿ�</a>

	<%
		} else {
	%>
	<a href='loginui.do'>�α���</a>
	<%
		}
	%>
</header>
