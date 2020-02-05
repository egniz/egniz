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

<a href="binsertui.do">글쓰기</a>
	<h1>게시판</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>게시판번호</th>
				<th>제목</th>
				<th>작성자</th> 
				<th>작성일</th>
				<th>조회수</th>
				<th>root</th>
				<th>step</th>
				<th>indent</th>
				<c:if test="${login.nkey >=100 }">
				<th>삭제</th>	
				</c:if>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list }" var="dto">
		<tr>
				<td>${dto.num } 
				<td>
				<c:forEach begin="1" end="${dto.repIndent }">
				&nbsp; </c:forEach>
				<a href="bread.do?num=${dto.num }">
				${dto.title }</a></td>
				<td>${dto.id }</td>
				<td>${dto.writeday }</td>
				<td>${dto.readcnt }</td>
				<td>${dto.repRoot }</td>
				<td>${dto.repStep }</td>
				<td>${dto.repIndent }</td>
				<c:if test="${login.nkey >=100 }">
				<td><a href="bdelete.do?id=${dto.num }">삭제</a></td>	
				</c:if>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<jsp:include page="page.jsp"/> 
</body>
</html>