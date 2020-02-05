<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>회원 목록</h1>

<c:forEach items="${mList }" var="var">
	id : ${var.id }  
	이름 : ${var.name }
	<a href="mRead.do?id=${var.id}">정보 보기</a>
	
	<c:if test="${var.nKey !=1000}">
	&nbsp;&nbsp;<a href="mDelete.do?id=${var.id }">강퇴</a>
	</c:if>
	<c:if test="${var.nKey ==1000}">
	&nbsp;&nbsp;<a href="bList.do?id=${var.id }">게시글보기</a>
	</c:if>
	<c:if test="${var.nKey !=1000}">
	<select name="ckey">
		<option value="100" id="${login.nKey }">관리자</option>
		<option value="10" id="${login.nKey }">회원</option>
	</select>
	</c:if>
	<br> 
</c:forEach>

<div>
<a href="mInsertUi.do">회원가입</a>
<a href="mList.do">회원정보</a>
</div>
</body>
</html>