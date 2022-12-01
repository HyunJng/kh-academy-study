<%@page import="java.util.Calendar"%>
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
	String id = request.getParameter("id");
	String hobby= request.getParameter("hobby");
	String name = request.getParameter("name");
	%>
	
	<h3>forward한 parameter값 보기</h3>
	<p>이름이 <b><%=name %></b>이고, ID가 <b><%=id %></b>님인 취미는 <b><%=hobby %></b>입니다.</p>
	
	<h3>현재 시간 보기</h3>
	<%
	Calendar cal = (Calendar)request.getAttribute("time");
	%>
	<p>현재 시간은 <%=cal.get(Calendar.HOUR) %>시 <%=cal.get(Calendar.MINUTE) %>분
	<%=cal.get(Calendar.SECOND) %>초 입니다.</p>
</body>
</html>