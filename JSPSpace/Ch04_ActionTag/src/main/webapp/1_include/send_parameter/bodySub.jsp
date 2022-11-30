<%@page import="java.util.Enumeration"%>
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
	String name = request.getParameter("name");
	%>
	<p>bodySub에서 name parameter값 : <%=name%>;</p>
	
	<h3>name parameter 값 목록</h3>
	<ul>
	<%
	String[] names = request.getParameterValues("name");
	for(String n : names){
	%>
		<li><%=n %></li>
	<% 
	}
	%>
	</ul>
</body>
</html>