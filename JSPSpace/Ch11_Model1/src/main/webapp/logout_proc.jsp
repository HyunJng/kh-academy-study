<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 1. Web Browser와 연결된 session으로 강제로 종료
	session.invalidate();

	// 2. session 종료 후 login화면으로 이동
	response.sendRedirect("login.jsp");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>