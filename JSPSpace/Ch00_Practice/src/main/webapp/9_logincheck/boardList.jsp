<%@page import="p09.filter.logincheck.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시판 리스트 보여주는 화면</h3>
<%
	Member member = (Member)session.getAttribute("MEMBER");	
	String id = member.getId();
	String pw = member.getPassword();
	
	out.print(id);
	out.print(pw);
%>
</body>
</html>