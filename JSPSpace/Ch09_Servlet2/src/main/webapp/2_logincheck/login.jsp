<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 처리 화면 </h3>
	<%
	String memberId = request.getParameter("memberId");
	session.setAttribute("MEMBER", memberId);
	String password = request.getParameter("password");
	%>
</body>
</html>