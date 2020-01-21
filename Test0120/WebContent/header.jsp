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
	<!-- out.print(dto.getName()); 이 부분이 위의 줄로 변경됨-->
	님, 환영합니다. <a href='logout.do'>로그아웃</a>

	<%
		} else {
	%>
	<a href='loginui.do'>로그인</a>
	<%
		}
	%>
</header>
