<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그아웃 처리</h3>
	<%
	session.invalidate();
	%>
	<p>로그아웃 하였습니다.</p>
</body>
</html>