<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie c = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
	// response header의 Set-Cookie에 저장이 되어 web browser로 전송됨
	response.addCookie(c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키 이름 : <%= c.getName() %> <br>
쿠키 value : <%= c.getValue() %> 
</body>
</html>