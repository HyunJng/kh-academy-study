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
	<%
	MemberInfo member = (MemberInfo)session.getAttribute("MEMBER");
	
	boolean login = member != null ? true:false;
	%>
	<h3>로그인 여부 검사</h3>
	<%
	if(login){
	%>
	<p>아이디  <%=member.getId()%>로 로그인한 상태입니다.</p>
	<%
	}else{
	%>
	<p>로그인 상태가 아닙니다.</p>
	<%
	}
	%>
</body>
</html>