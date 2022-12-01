<%@page import="member.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 속성 설정</h3>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	
	MemberInfo member = new MemberInfo(id, pw);
	
	session.setAttribute("member", member);
	%>
	
	<%
	MemberInfo m = (MemberInfo) session.getAttribute("member");
	%>
	
	<p>id = <%= m.getId() %></p>
	<p>password = <%= m.getPasswd()%></p>
	
</body>
</html>