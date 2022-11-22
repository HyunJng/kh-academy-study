<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	pageContext.setAttribute("name", "pageContext데이터");
	%>
	<h3>JSP code 내의 다른 프로그램 소스 코드 내용 존재</h3>
	
	<h3>pageCOntext attribute 조회 및 사용하기</h3>
	<h3><%= pageContext.getAttribute("name") %></h3>
</body>
</html>