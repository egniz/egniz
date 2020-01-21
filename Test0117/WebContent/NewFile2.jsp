<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<%! 
	public void me1(){
		System.out.print("hello");
	}
	
	%>
	
	<% 
	int a = 3; 
	me1();
	a=5;
	%>
	
	<% if (a>10){
		out.print("<a href='naver.com'>naver</a>");}
	else{
		out.print("<a href='google.com'>naver</a>");}
	
	%>
	<%
	
	%>
	
</body>
</html>